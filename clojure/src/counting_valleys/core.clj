(ns counting-valleys.core)

;; https://www.hackerrank.com/challenges/counting-valleys/problem

(defn is-valley-finished [[el1 el2]]
  (and (= -1 el1) (= 0 el2)))

(defn countingValleys [_ s]
  (count
    (filter is-valley-finished
            (partition 2
                       (reductions + (map #(if (= "U" %) 1 -1)
                                          (clojure.string/split s #"")))))))

(= 1 (countingValleys 1 "UDDDUDUU"))
(= 2 (countingValleys 1 "DDUUDDUDUUUD"))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def s (read-line))

(def result (countingValleys n s))

(spit fptr (str result "\n") :append true)
