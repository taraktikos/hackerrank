(ns kangaroo.core)

;; https://www.hackerrank.com/challenges/kangaroo/problem
(defn kangaroo [x1 v1 x2 v2]
  (if (and (> v1 v2)
           (= 0 (mod (- x2 x1) (- v1 v2))))
    "YES"
    "NO"))

(= "YES"
   (kangaroo 0 3 4 2))

(and (> 5 0) (>= 3 2))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def x1V1X2V2 (clojure.string/split (read-line) #" "))

(def x1 (Integer/parseInt (clojure.string/trim (nth x1V1X2V2 0))))

(def v1 (Integer/parseInt (clojure.string/trim (nth x1V1X2V2 1))))

(def x2 (Integer/parseInt (clojure.string/trim (nth x1V1X2V2 2))))

(def v2 (Integer/parseInt (clojure.string/trim (nth x1V1X2V2 3))))

(def result (kangaroo x1 v1 x2 v2))

(spit fptr (str result "\n") :append true)
