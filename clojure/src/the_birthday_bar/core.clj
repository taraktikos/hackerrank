(ns the-birthday-bar.core)


;; https://www.hackerrank.com/challenges/the-birthday-bar/problem?h_r=next-challenge&h_v=zen

(defn sum [coll]
  (reduce + coll))

(defn sub-slices [col size]
  (if (>= (count col) size)
    (concat [(take size col)] (sub-slices (rest col) size))
    nil))

(defn birthday [s d m]
  (count (filter #(= d (sum %)) (sub-slices s m))))

(= 2 (birthday [1 2 1 3 2] 3 2))

(= 1 (birthday [4] 4 1))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def s (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def dm (clojure.string/split (clojure.string/trimr (read-line)) #" "))

(def d (Integer/parseInt (nth dm 0)))

(def m (Integer/parseInt (nth dm 1)))

(def result (birthday s d m))

(spit fptr (str result "\n") :append true)
