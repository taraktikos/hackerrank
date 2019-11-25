(ns utopian-tree.core)

(defn utopianTree [n]
  (reduce #(%2 %1) 1
          (take n (flatten (repeat [(partial * 2) (partial + 1)])))))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def t (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [_ (range t)]
  (def n (Integer/parseInt (clojure.string/trim (read-line))))

  (def result (utopianTree n))

  (spit fptr (str result "\n") :append true))
