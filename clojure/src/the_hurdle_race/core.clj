(ns the-hurdle-race.core)

(defn hurdleRace [k heights]
  (let [max (apply max heights)]
    (if (> max k)
      (- max k)
      0)))

(= 2 (hurdleRace 4 [1 6 3 5 2]))

(= 0 (hurdleRace 7 [2 5 4 5 2]))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nk (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

(def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

(def height (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (hurdleRace k height))

(spit fptr (str result "\n") :append true)
