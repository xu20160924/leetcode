#!/usr/bin/env bash
#awk '{print "value:" NF}' /Users/johnMacBookPro/IdeaProjects/arithmetic/src/main/java/com/leetcode/shell/test
awk '{
  for (i = 1; i <= NF; i++) {
    if (NR == 1) {
      s[i] = $i;
      print "value1:" $i  "  NF:"  NF;
    } else {
      print "value:" $i "   NF:" NF;
      s[i] = s[i] " " $i;
    }
  }
}' /Users/johnMacBookPro/IdeaProjects/arithmetic/src/main/java/com/leetcode/shell/test
