(ns sock-merchant.core)

;; https://www.hackerrank.com/challenges/sock-merchant/problem
(defn sockMerchant [_ ar]
  (reduce + (map #(quot (val %) 2)
                 (frequencies ar))))

(= 3
   (sockMerchant 7 [10 20 20 10 10 30 50 10 20]))


(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def ar (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (sockMerchant n ar))

(spit fptr (str result "\n") :append true)
