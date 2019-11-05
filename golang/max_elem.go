package main

import "fmt"

// https://www.hackerrank.com/challenges/maximum-element/problem
func main() {
	var maxNum int
	var stack []int
	number := readInt()
	for i := 0; i < number; i++ {
		qType := readInt()
		switch qType {
		case 1:
			numToInsert := readInt()
			if numToInsert > maxNum {
				maxNum = numToInsert
			}
			stack = append(stack, numToInsert)
		case 2:
			topOfStack := len(stack) - 1
			removedElem := stack[topOfStack]
			stack = stack[:topOfStack]
			if removedElem == maxNum {
				maxNum = 0
				for _, elem := range stack {
					if elem > maxNum {
						maxNum = elem
					}
				}
			}
		case 3:
			fmt.Printf("%d\n", maxNum)
		}
	}
}

func readInt() int {
	var number int
	_, _ = fmt.Scanf("%d", &number)
	return number
}

/*
Input
7
1 1
1 44
3
3
2
3
3

Output
44
44
1
1
*/
