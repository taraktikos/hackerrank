package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

//https://www.hackerrank.com/challenges/diagonal-difference/problem

func diagonalDifference(arr [][]int32) int32 {
	var sum1 int32
	var sum2 int32
	for i, j := 0, len(arr)-1; i < len(arr); i, j = i+1, j-1 {
		sum1 = sum1 + arr[i][i]
		sum2 = sum2 + arr[i][j]
	}
	return abs(sum1 - sum2)
}

func abs(n int32) int32 {
	if n < 0 {
		return -n
	}
	return n
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout := os.Stdout

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	nTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	n := int32(nTemp)

	var arr [][]int32
	for i := 0; i < int(n); i++ {
		arrRowTemp := strings.Split(strings.TrimRight(readLine(reader), " \t\r\n"), " ")

		var arrRow []int32
		for _, arrRowItem := range arrRowTemp {
			arrItemTemp, err := strconv.ParseInt(arrRowItem, 10, 64)
			checkError(err)
			arrItem := int32(arrItemTemp)
			arrRow = append(arrRow, arrItem)
		}

		if len(arrRow) != int(n) {
			panic("Bad input")
		}

		arr = append(arr, arrRow)
	}

	result := diagonalDifference(arr)

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
