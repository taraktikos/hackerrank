(ns cats-and-a-mouse.core)

;; https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
(defn catAndMouse [x y z]
  (let [d1 (Math/abs (- x z))
        d2 (Math/abs (- y z))]
    (cond
      (< d1 d2) "Cat A"
      (> d1 d2) "Cat B"
      :else     "Mouse C")))

(= "Cat B"
   (catAndMouse 1 2 3))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def q (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [q-itr (range q)]
  (def xyz (clojure.string/split (read-line) #" "))

  (def x (Integer/parseInt (clojure.string/trim (nth xyz 0))))

  (def y (Integer/parseInt (clojure.string/trim (nth xyz 1))))

  (def z (Integer/parseInt (clojure.string/trim (nth xyz 2))))

  (def result (catAndMouse x y z))

  (spit fptr (str result "\n") :append true))
