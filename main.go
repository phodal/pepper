package main

import (
	"fmt"
	"github.com/alecthomas/chroma/quick"
	. "github.com/phodal/pepper/data"
	"os"
)

func main() {
	argsWithoutProg := os.Args[1:]

	codeMap := map[string]string{
		"Date":      "code/src/test/java/com/phodal/pepper/normal/date/mockito/MyDateClassTest.java",
		"Exception": "code/src/test/java/com/phodal/pepper/normal/exception/MyDictionaryExceptionTest.java",
		"NewFile":   "code/src/test/java/com/phodal/pepper/normal/file/NewFileClassExampleTest.java",
	}

	if len(argsWithoutProg) > 0 && argsWithoutProg[0] == "list" {
		for _, key := range codeMap {
			fmt.Println(key)
		}
		return
	}

	if len(argsWithoutProg) > 1 && argsWithoutProg[0] == "help" {
		fmt.Println(argsWithoutProg[1])
		bytes, _ := Asset(codeMap[argsWithoutProg[1]])

		err := quick.Highlight(os.Stdout, string(bytes), "go", "terminal16m", "monokai")
		if err != nil {
			fmt.Println(err)
		}
	}
}
