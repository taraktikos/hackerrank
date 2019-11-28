(ns strange-advertising.core)

;; https://www.hackerrank.com/challenges/strange-advertising/problem
(defn like-counts [day shared]
  (when (> day 0)
    (let [liked (quot shared 2)]
      (conj (like-counts (dec day) (* 3 liked)) liked))))

(defn viralAdvertising [n]
  (reduce + (like-counts n 5)))

(= 24 (viralAdvertising 5))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def result (viralAdvertising n))

(spit fptr (str result "\n") :append true)
