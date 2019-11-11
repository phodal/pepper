package main

import (
	"fmt"
	"github.com/alecthomas/chroma/quick"
	"os"
)

func main() {
	err := quick.Highlight(os.Stdout, "package main", "go", "terminal16m", "monokai")
	if err != nil {
		fmt.Println(err)
	}
}
