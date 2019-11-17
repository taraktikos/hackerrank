(ns migratory-birds.core)

;; https://www.hackerrank.com/challenges/migratory-birds/problem

(defn compare-second-desc-first-asc [a b]
  (let [c (compare (first b) (first a))]
    (if (not= c 0)
      c
      (let [c (compare (second a) (second b))]
        c))))

(defn migratoryBirds [arr]
  (first
    (first
      (sort-by (juxt val key)
               compare-second-desc-first-asc
               (frequencies arr)))))

(= 3
   (migratoryBirds [1 2 3 4 5 4 3 2 1 3 4]))

(= 3
   (migratoryBirds [2 4 3 2 3 1 2 1 3 3]))

(= 4
   (migratoryBirds [1 4 4 4 5 3]))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def arr-count (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (migratoryBirds arr))

(spit fptr (str result "\n") :append true)
