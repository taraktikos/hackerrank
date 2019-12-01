(ns permutation-equation.core)

;; https://www.hackerrank.com/challenges/permutation-equation/problem
(defn permutationEquation [p]
  (let [len     (count p)
        val-key (into {} (map-indexed (fn [i e] [e (inc i)]) p))]
    (map #(get val-key (get val-key %)) (range 1 (inc len)))))

(= [1 3 5 4 2] (permutationEquation [4 3 5 1 2]))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def p (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (permutationEquation p))

(spit fptr (clojure.string/join "\n" result) :append true)
(spit fptr "\n" :append true)
