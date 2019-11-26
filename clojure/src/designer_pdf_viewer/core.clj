(ns designer-pdf-viewer.core)

(def alphabet (zipmap (map #(str (char %)) (range (int \a) (inc (int \z)))) (range)))

(defn designerPdfViewer [h word]
  (let [cnt        (count word)
        max-height (apply max (map #(nth h (get alphabet %)) (clojure.string/split word #"")))]
    (* cnt max-height)))

(def h [1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])
(def word "abc")

(= 9 (designerPdfViewer h word))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def h (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def word (read-line))

(def result (designerPdfViewer h word))

(spit fptr (str result "\n") :append true)
