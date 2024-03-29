package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// https://www.hackerrank.com/challenges/birthday-cake-candles/problem
func birthdayCakeCandles(ar []int32) int32 {
	var max int32
	var maxCount int32
	for _, elem := range ar {
		if elem == max {
			maxCount++
		}
		if elem > max {
			max = elem
			maxCount = 1
		}
	}
	return maxCount
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout := os.Stdout // os.Create(os.Getenv("OUTPUT_PATH"))
	//checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	arCount, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)

	arTemp := strings.Split(readLine(reader), " ")

	var ar []int32

	for i := 0; i < int(arCount); i++ {
		arItemTemp, err := strconv.ParseInt(arTemp[i], 10, 64)
		checkError(err)
		arItem := int32(arItemTemp)
		ar = append(ar, arItem)
	}

	result := birthdayCakeCandles(ar)

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
