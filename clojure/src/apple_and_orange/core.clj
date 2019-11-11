(ns apple-and-orange.core)

;;https://www.hackerrank.com/challenges/apple-and-orange/problem
;; Complete the countApplesAndOranges function below.

(defn count-fruit [s t dx fruits]
  (let [distances (map #(+ dx %) fruits)]
    (count (filter #(<= s % t) distances))))

(defn countApplesAndOranges [s t a b apples oranges]
  [(count-fruit s t a apples)
   (count-fruit s t b oranges)])

(= (countApplesAndOranges 7 11 5 15 [-2 2 1] [5 -6])
   [1 1])

(def st (clojure.string/split (read-line) #" "))

(def s (Integer/parseInt (clojure.string/trim (nth st 0))))

(def t (Integer/parseInt (clojure.string/trim (nth st 1))))

(def ab (clojure.string/split (read-line) #" "))

(def a (Integer/parseInt (clojure.string/trim (nth ab 0))))

(def b (Integer/parseInt (clojure.string/trim (nth ab 1))))

(def mn (clojure.string/split (read-line) #" "))

(def m (Integer/parseInt (clojure.string/trim (nth mn 0))))

(def n (Integer/parseInt (clojure.string/trim (nth mn 1))))

(def apples (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def oranges (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(print
  (clojure.string/join "\n"
                       (countApplesAndOranges s t a b apples oranges)))
