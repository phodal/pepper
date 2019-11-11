package main

import (
	"fmt"
	"github.com/alecthomas/chroma/quick"
	. "github.com/phodal/pepper/data"
	"os"
)

func main() {
	codeMap := map[string]string{
		"Date": "code/src/test/java/com/phodal/pepper/normal/date/mockito/MyDateClassTest.java",
		"Exception": "code/src/test/java/com/phodal/pepper/normal/exception/MyDictionaryExceptionTest.java",
		"NewFile": "code/src/test/java/com/phodal/pepper/normal/file/NewFileClassExampleTest.java",
	}

	bytes, _ := Asset(codeMap["Date"])

	err := quick.Highlight(os.Stdout, string(bytes), "go", "terminal16m", "monokai")
	if err != nil {
		fmt.Println(err)
	}
}
