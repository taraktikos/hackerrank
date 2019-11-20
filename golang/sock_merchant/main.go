package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
	"strconv"
	"strings"
)

// Complete the sockMerchant function below.
func sockMerchant(n int32, ar []int32) int32 {
	sort.Slice(ar, func(i, j int) bool {
		return ar[i] < ar[j]
	})
	var pairs int32
	for i := 0; i < len(ar)-1; i++ {
		if ar[i] == ar[i+1] {
			pairs++
			i++
		}
	}
	return pairs
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)
	n := int32(nTemp)

	arTemp := strings.Split(readLine(reader), " ")

	var ar []int32

	for i := 0; i < int(n); i++ {
		arItemTemp, err := strconv.ParseInt(arTemp[i], 10, 64)
		checkError(err)
		arItem := int32(arItemTemp)
		ar = append(ar, arItem)
	}

	result := sockMerchant(n, ar)

	fmt.Fprintf(writer, "%d\n", result)

	writer.Flush()

	//	print(sockMerchant(1, []int32{10, 20, 20, 10, 10, 30, 50, 10, 20}))
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
