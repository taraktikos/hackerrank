(ns between-two-sets.core)

;; https://www.hackerrank.com/challenges/between-two-sets/problem

(defn is-factors-of [factors num]
  (every? #(zero? (mod num %)) factors))

(defn is-factor-for [factor numbers]
  (every? #(zero? (mod % factor)) numbers))

(defn getTotalX [a b]
  (let [all-nums (range (last a) (inc (first b)))
        factors  (filter #(is-factors-of a %) all-nums)
        result   (filter #(is-factor-for % b) factors)]
    (count result)))

(= 3 (getTotalX [2 4] [16 32 96]))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def first-multiple-input (clojure.string/split (clojure.string/trimr (read-line)) #" "))

(def n (Integer/parseInt (nth first-multiple-input 0)))

(def m (Integer/parseInt (nth first-multiple-input 1)))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def brr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def total (getTotalX arr brr))

(spit fptr (str total "\n") :append true)
