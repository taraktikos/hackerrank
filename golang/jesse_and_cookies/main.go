package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

//https://www.hackerrank.com/challenges/jesse-and-cookies/problem

type IntHeap []int32

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int32))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

/*
 * Complete the cookies function below.
 */
func cookies(k int32, A []int32) int32 {
	var numOp int32 = 0
	priorityQueue := &IntHeap{}
	heap.Init(priorityQueue)
	for _, elem := range A {
		heap.Push(priorityQueue, elem)
	}
	if priorityQueue.Len() < 1 {
		return -1
	}
	for {
		leastSweetness := heap.Pop(priorityQueue).(int32)
		if leastSweetness >= k {
			return numOp
		}
		if priorityQueue.Len() < 1 {
			return -1
		}
		newSweetness := leastSweetness + 2*heap.Pop(priorityQueue).(int32)
		priorityQueue.Push(newSweetness)
		numOp++
	}
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 4024*4024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nk := strings.Split(readLine(reader), " ")

	nTemp, err := strconv.ParseInt(nk[0], 10, 64)
	checkError(err)
	n := int32(nTemp)

	kTemp, err := strconv.ParseInt(nk[1], 10, 64)
	checkError(err)
	k := int32(kTemp)

	ATemp := strings.Split(readLine(reader), " ")

	var A []int32

	for AItr := 0; AItr < int(n); AItr++ {
		AItemTemp, err := strconv.ParseInt(ATemp[AItr], 10, 64)
		checkError(err)
		AItem := int32(AItemTemp)
		A = append(A, AItem)
	}

	result := cookies(k, A)

	fmt.Fprintf(writer, "%d\n", result)

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
