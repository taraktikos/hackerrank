(ns equal-stacks.core)
; https://www.hackerrank.com/challenges/equal-stacks/problem

(defn check-equal [h1 h2 h3]
  (let [head1 (or (first h1) 0)
        head2 (or (first h2) 0)
        head3 (or (first h3) 0)
        max (max head1 head2 head3)]
    (if (and (= head1 head2) (= head2 head3))
      head1
      (if (= head1 max)
        (recur (rest h1) h2 h3)
        (if (= head2 max)
          (recur h1 (rest h2) h3)
          (recur h1 h2 (rest h3)))))))

(defn equalStacks [h1 h2 h3]
  (let [cum-h1 (reverse (reductions + (reverse h1)))
        cum-h2 (reverse (reductions + (reverse h2)))
        cum-h3 (reverse (reductions + (reverse h3)))]
    (check-equal cum-h1 cum-h2 cum-h3)))

(def fptr "test.txt")

(def n1N2N3 (clojure.string/split (read-line) #" "))

(def n1 (Integer/parseInt (clojure.string/trim (nth n1N2N3 0))))

(def n2 (Integer/parseInt (clojure.string/trim (nth n1N2N3 1))))

(def n3 (Integer/parseInt (clojure.string/trim (nth n1N2N3 2))))

(def h1 (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def h2 (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def h3 (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (equalStacks h1 h2 h3))

(spit fptr (str result "\n") :append true)