(ns electronics-shop.core)

;; https://www.hackerrank.com/challenges/electronics-shop/problem
(defn getMoneySpent [keyboards drives b]
  (let [sums   (for [k keyboards
                     d drives]
                 (+ k d))
        sorted (sort (filter #(<= % b) sums))]
    (if (empty? sorted)
      -1
      (last sorted))))

(= 9
   (getMoneySpent [3 1] [5 2 8] 10))

(= -1
   (getMoneySpent [4] [5] 5))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def bnm (clojure.string/split (read-line) #" "))

(def b (Integer/parseInt (clojure.string/trim (nth bnm 0))))

(def n (Integer/parseInt (clojure.string/trim (nth bnm 1))))

(def m (Integer/parseInt (clojure.string/trim (nth bnm 2))))

(def keyboards (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def drives (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def moneySpent (getMoneySpent keyboards drives b))

(spit fptr (str moneySpent "\n") :append true)
