(ns equality-in-a-array.core)

(defn equalizeArray [arr]
  (let [c   (count arr)
        max (val (first (reverse (sort-by val (frequencies arr)))))]
    (- c max)))

(equalizeArray [2 3 1 3 3])
;; => 2

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (equalizeArray arr))

(spit fptr (str result "\n") :append true)
