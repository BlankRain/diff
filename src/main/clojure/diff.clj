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
    (let [left [2 3 4 5 6]
          right [4 5 6 7 8]
          fl identity
          fr identity]
        (diff left right fl fr)))
