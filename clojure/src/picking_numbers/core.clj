(ns picking-numbers.core)

;; https://www.hackerrank.com/challenges/picking-numbers/problem
(defn pickingNumbers [a]
  (let [freq (frequencies a)
        sums (for [i (range 0 100)]
               (let [el      (get freq i 0)
                     el-next (get freq (inc i) 0)]
                 (+ el el-next)))]
    (apply max sums)))

(= 2 (pickingNumbers [4 6 3 6 1]))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def a (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (pickingNumbers a))

(spit fptr (str result "\n") :append true)
