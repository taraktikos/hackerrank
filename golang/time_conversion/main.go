package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// https://www.hackerrank.com/challenges/time-conversion/problem
func timeConversion(s string) string {
	lenS := len(s)
	amPm := s[lenS-2:]
	minutes := s[2 : lenS-2]
	hour, _ := strconv.Atoi(s[:2])
	if amPm == "AM" {
		if hour == 12 {
			return "00" + minutes
		}
		return s[:lenS-2]
	}
	if hour == 12 && amPm == "PM" {
		return "12" + minutes
	}
	return strconv.Itoa(hour+12) + minutes
}

func main() {
	//reader := bufio.NewReaderSize(os.Stdin, 1024 * 1024)

	outputFile := os.Stdout //os.Create(os.Getenv("OUTPUT_PATH"))

	defer outputFile.Close()

	writer := bufio.NewWriterSize(outputFile, 1024*1024)

	//s := readLine(reader)

	result := timeConversion("06:40:03AM")

	fmt.Fprintf(writer, "%s\n", result)

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
