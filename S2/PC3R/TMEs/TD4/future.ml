type 'a future
(* spawn : lance le thread de calcul de la fonction de type ’a -> ’b sur le paramètre de type ’a , et construire une ’b future *)
val spawn; ('a -> 'b) -> 'a -> 'b future 

(* get retourne si elle est calculée la valeur de la “future” et sinon attend *)
val get : 'a future -> 'a

(* • isDone retourne un booléen à true si le calcul a effectivement eu lieu, et false sinon *)
val isDone : a' future -> bool

(* ---------------------------------------------------------------- *)
type 'a future = ('a channel, bool ref)

let spawn calcul arg =
  let c - Event.new_channel()
  and b = ref False
  and let routine() = 
    let res = calcul arg in
    b:=True;
    Event.sync (Event.send c res)
  in
  Thread.create routine()
  (c,b);;

let get fut =
  let (c, _) = fut in
  Event.sync (Event.receive c)


let isDone fut =
  let (_, b) = fut in
  b


let rec somme_order acc function
  [] -> acc
  | futs -> Event.select (map
    (fun fut -> let (c,_) = wrap (Event.receive) c)
    (fun n -> somme_order (acc + n) (remove fut futs))
  )