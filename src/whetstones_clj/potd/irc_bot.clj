;; URL:
;; http://www.problemotd.com/problem/irc-bot/
;;
;; Description:
;; Today's problem is a fun one. We'll be creating an IRC bot. Your bot can connect to any channel and on any network
;; (freenode.net is a good place to start if you're unsure). The goal of this bot is to print to console everything
;; that is said in the irc channel. For bonus points have your both listen in on two channels and print both channels
;; to the console.

(ns whetstones-clj.potd.irc-bot
  (:require [clojure.string :as str])
  (:import (java.net Socket)
           (java.io PrintWriter InputStreamReader BufferedReader)))

(defn- write
  [conn & msg]
  (doto ^PrintWriter (:out @conn)
    (.println (str/join (conj msg "\r")))
    (.flush)))

(defn- edit-conn
  [conn k v]
  (dosync (alter conn assoc k v))
  conn)

(defn- conn-handler
  [conn]
  (while (not (:exit @conn))
    (let [msg (.readLine (:in @conn))]
      (cond
        (re-find #"^:[^ ]* 004" msg)
        (edit-conn conn :connected true)
        (re-find #"^:[^ :]* PRIVMSG #" msg)
        (let [[_ nick chan msg] (re-find #"^:([^!]*)!.*PRIVMSG ([^ ]*) :(.*)" msg)]
          (println (str chan " " nick ": " msg)))
        (re-find #"^ERROR :Closing Link:" msg)
        (edit-conn conn :exit true)
        (re-find #"^PING" msg)
        (write conn (str "PONG " (re-find #":.*" msg)))))))

(defn- connect
  [server port]
  (let [socket (Socket. (str server) (int port))
        in     (BufferedReader. (InputStreamReader. (.getInputStream socket)))
        out    (PrintWriter. (.getOutputStream socket))
        conn   (ref {:in in :out out})
        thread (Thread. ^Runnable #(conn-handler conn))]
    (.start thread)
    (edit-conn conn :handler thread)))

(defn- login
  [conn nick]
  (write conn "NICK " nick)
  (write conn "USER " nick " 0 * :" nick))

(defn- await-conn
  [conn timeout]
  (let [wait (atom 0)]
    (while (and (not (:connected @conn))
                (not (:exit @conn)))
      (if (< @wait timeout)
        (do (Thread/sleep 100)
            (swap! wait + 100))
        (edit-conn conn :exit true)))))

(defn- sanitize-channel
  [channel]
  (if-not (.startsWith channel "#")
    (str "#" channel)
    channel))

(defn- join
  [conn channel]
  (write conn "JOIN " (sanitize-channel channel)))

(defn start-listening
  [server port nick & channels]
  (let [conn (connect server port)]
    (login conn nick)
    (println "Connecting...")
    (await-conn conn 15000)
    (println "Connected...")
    (doseq [channel channels]
      (join conn channel))))
