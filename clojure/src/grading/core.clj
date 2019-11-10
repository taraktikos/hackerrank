(ns grading.core)

;; https://www.hackerrank.com/challenges/grading/problem
(defn multiple-of-5 [from]
  (first (take 1 (filter #(= 0 (mod % 5)) (range from 101 1)))))

(defn gradingStudents [grades]
  (map (fn [g]
         (cond
           (< g 38) g
           :else    (let [m-of-5 (multiple-of-5 g)]
                      (if (< (- m-of-5 g) 3)
                        m-of-5
                        g)))) grades))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def grades-count (Integer/parseInt (clojure.string/trim (read-line))))

(def grades [])

(doseq [_ (range grades-count)]
(def grades (conj grades (Integer/parseInt (clojure.string/trim (read-line)))))
)

(def result (gradingStudents grades))

(spit fptr (clojure.string/join "\n" result) :append true)
(spit fptr "\n" :append true)

;; (def grades [73 67 38 33])

;; (= [75 67 40 33]
;;    (gradingStudents grades))
