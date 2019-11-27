(ns beautiful-days-at-the-movies.core)

;; https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

(defn reverse-number [num]
  (Integer/parseInt (clojure.string/join (reverse (str num)))))

(defn beautifulDays [i j k]
  (count (filter #(= (mod % k) 0)
                 (map #(- % (reverse-number %)) (range i (inc j))))))

(= 2 (beautifulDays 20 23 6))


(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def ijk (clojure.string/split (read-line) #" "))

(def i (Integer/parseInt (clojure.string/trim (nth ijk 0))))

(def j (Integer/parseInt (clojure.string/trim (nth ijk 1))))

(def k (Integer/parseInt (clojure.string/trim (nth ijk 2))))

(def result (beautifulDays i j k))

(spit fptr (str result "\n") :append true)
