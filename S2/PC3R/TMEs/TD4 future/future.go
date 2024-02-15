package main

type futureInt struct {
	fut chat int
	fini bool
}

func spawnIntInt(calcul func(int) int, arg int) futureInt {
	c:= make(chan int)
	*d := false // pointer

	go func() {
		res:= calcul arg
		*d = true
		c <- res
	} ()
	return futureInt{fut:c , fini:d}
}


func getInt(f futureInt) {
	return <- f.fut
}

fun isDone(f futureInt) {
	return <- f.(*fini)
}