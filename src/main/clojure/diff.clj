(println "diff algorithms in clojure")

(defn diff 
 ([left right fl fr]
  (let 
    [doWeTheSame? (fn [me you fnme fnyou] (= (fnme me) (fnyou you)))
     both 
     (filter (comp not nil?) 
       (flatten 
         (map (fn [leftnode] 
               (map 
                 (fn [rightnode] 
                  (if (doWeTheSame? leftnode rightnode fl fr) {:leftnode leftnode :rightnode rightnode}))
                 right))
             left)))
    
     onlyleft  (remove (set  (map :leftnode both)) left)
     onlyright (remove (set  (map :rightnode both)) right)] 
   {:both both :onlyleft onlyleft :onlyright onlyright}))
 ([left right] (diff left right identity identity))
 ([left right f] (diff left right f f)))  
        

(defn demo []
    (let [left [{:k 2} {:k 3} {:k 4} {:k 5} {:k 6}]
          right [4 5 6 7 8]
          fl :k
          fr identity]
        (diff left right fl fr )))

; user=> (pprint (demo))
; {:both
;  ({:leftnode {:k 4}, :rightnode 4}
;   {:leftnode {:k 5}, :rightnode 5}
;   {:leftnode {:k 6}, :rightnode 6}),
;  :onlyleft ({:k 2} {:k 3}),
;  :onlyright (7 8)}
; nil
