(ns angry-professor.core)

(defn angryProfessor [k a]
  (let [c (count (filter #(<= % 0) a))]
    (if (< c k)
      "YES"
      "NO")))

(= "YES" (angryProfessor 3 [-1 -3 4 2]))
(= "NO" (angryProfessor 2 [0 -1 2 1]))


(angryProfessor 4 [-93 -86 49 -62 -90 -63 40 72 11 67])

(angryProfessor 10 [23 -35 -2 58 -67 -56 -42 -73 -19 37])
;; => "YES"
(angryProfessor 9 [13 91 56 -62 96 -5 -84 -36 -46 -13])
;; => "YES"
(angryProfessor 8 [45 67 64 -50 -8 78 84 -51 99 60])
;; => "YES"
(angryProfessor 7 [26 94 -95 34 67 -97 17 52 1 86])

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def t (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [t-itr (range t)]
  (def nk (clojure.string/split (read-line) #" "))

  (def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

  (def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

  (def a (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

  (def result (angryProfessor k a))

  (spit fptr (str result "\n") :append true))
