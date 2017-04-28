(println "diff algorithms in clojure")
(defn doWeTheSame [me you fm fy] 
    (= (fm me) (fy you)))

(defn diff [left right fl fr]
  (let 
    [both 
     (filter (comp not nil?) 
       (flatten 
         (map (fn [leftnode] 
               (map 
                 (fn [rightnode] 
                  (if (doWeTheSame leftnode rightnode fl fr) {:leftnode leftnode :rightnode rightnode}))
                 right))
             left)))
    
     onlyleft '()
     onlyright '()] 
   {:both both :onlyleft onlyleft :onlyright onlyright}))  
        

(defn demo []
    (let [left [{:k 2} {:k 3} {:k 4} {:k 5} {:k 6}]
          right [4 5 6 7 8]
          fl :k
          fr identity]
        (diff left right fl fr)))

;Todo: onlyleft  onlyright
; user=> (pprint (demo))
; {:both
;  ({:leftnode {:k 4}, :rightnode 4}
;   {:leftnode {:k 5}, :rightnode 5}
;   {:leftnode {:k 6}, :rightnode 6}),
;  :onlyleft (),
;  :onlyright ()}
; nil
