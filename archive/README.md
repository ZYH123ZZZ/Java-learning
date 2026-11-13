# Java 代码归档（2026-10-01 ~ 2026-11-04）

**这里放的是"已经结课、不会再改"的代码。现在在写的东西放 `test\src\`。**

**为什么要搬进仓库里：** 放在仓库外面，Git 会把这些文件当成"删除"；放在里面，Git 能跟着历史走 —— 以后 `git log` 能查到任何一个文件的每一版。

---

## 怎么找文件

| 想干什么 | 怎么做 |
|---|---|
| 记得文件名 | IDEA 里按 **`Ctrl + Shift + N`**，打名字就有 |
| 记得代码内容 | IDEA 里按 **`Ctrl + Shift + F`**，搜一段代码 |
| 按时间翻 | 下面的目录表，一周一个文件夹，一天一个格子 |
| 按学习阶段翻 | 先想"这是第几周学的"，直接进 `week_N` |

---

## 目录结构

```
archive\
├── week_1\   第一周  Day1  ~ Day7      8 个目录   26 个文件
├── week_2\   第二周  Day8  ~ Day14     9 个目录   49 个文件
├── week_3\   第三周  Day15 ~ Day21     8 个目录   45 个文件
├── week_4\   第四周  Day22 ~ Day28     7 个目录   44 个文件
├── week_5\   第五周  Day29 ~ Day34    7 个目录   34 个文件
└── week_6\   第六周  Day36 ~ Day39    5 个目录   14 个文件
```

**分周规则：按目录名里最小的那个 Day 号归周。**

比如 `1017_Day14-15` 归 `week_2`（从 Day14 开始做的），`1025_Day21-22` 归 `week_3`。

---

## check 归档：查漏验收（2026-11-10）

2026-11-10 按 `E:\dsh\java\必背\查漏清单-2026-11-10.md` 做了 32 道查漏题（Day1 ~ Day39 全覆盖）。**到 2026-11-12 为止题号 1~22 全部通过**（11-10 当天 11 道 + 11-11 补课 11 道），代码归档到对应 Day 目录下新建的 `check\` 子目录。**还剩题号 23~32 共 10 道（第五、六周内容）没做**，等主线推到对应内容再一起做。

| 题号 | 考什么 | 归档到 | 文件 |
|---|---|---|---|
| 5 | Day6 数组 + `Arrays.toString` | `week_1\1005_Day6\check\` | `checkD6.java` |
| 6 | Day8 方法 + 返回值 | `week_2\1009_Day8\check\` | `checkD8.java` |
| 7 | Day9 方法进阶（数组当参数） | `week_2\1010_Day8-9\check\` | `checkD9.java` |
| 12 | Day15+16 类 / 构造 / 方法 | `week_3\1019_Day15-16\check\` | `checkD15and16.java`、`Goods_D15and16.java` |
| 13 | Day17 ArrayList | `week_3\1020_Day17\check\` | `checkD17.java` |
| 14 | Day18 泛型 + foreach | `week_3\1021_Day17-18\check\` | `checkD18.java` |
| 15 | Day19 HashMap + `keySet` 遍历 | `week_3\1022_Day19\check\` | `checkD19.java` |
| 16 | Day20 HashSet + 集合三兄弟 | `week_3\1023_Day20\check\` | `checkD20.java` |
| 17 | Day22 继承 | `week_3\1025_Day21-22\check\` | `checkD22.java`、`Animal_D22.java`、`Dog_D22.java` |
| 18 | Day23 重写 + `super.speak()` | `week_4\Day24\check\` | `checkD23.java`、`Animal_D23.java`、`Dog_D23.java` |
| 19 | Day24 多态 | `week_4\Day24\check\` | `checkD24.java`、`Animal_D24.java`、`Dog_D24.java` |
| 1 | Day1 变量 | `week_1\1001_Day1\check\` | `checkD1_A.java`、`checkD1_B.java`（11-11 补课重出） |
| 2 | Day2-3 Scanner | `week_1\1002_Day2-3\check\` | `checkD3.java`、`checkD3_A.java`、`checkD3_B.java` |
| 3 | Day4 if / switch | `week_1\1003_Day4\check\` | `checkD4.java`（11-11 把 70 改成 60 后过） |
| 8 | Day10 String 基础 | `week_2\1012_Day10-11\check\` | `checkD10andD11_A.java`（回文，11-11 补课重出） |
| 9 | Day11 String 进阶 | `week_2\1012_Day10-11\check\` | `checkD10andD11_B.java`（取后缀，11-11 补课重出） |
| 10 | Day12 嵌套循环 | `week_2\1015_Day12-13\check\` | `checkD12_A/B/C/D.java`（11-11 补课四道重出） |
| 11 | Day13 排序 | `week_2\1015_Day12-13\check\` | `checkD13.java`（冒泡四组边界全过） |
| 20 | Day25 抽象类 + 接口 | `week_4\Day25-发工资\check\` | `checkD25.java`、`Animal_D25`、`Duck_D25`、`Swimmable_D25`（第 20 题基础）；`checkD25_B.java`、`Shape_D25`、`Scalable_D25`、`Circle_D25`、`Rectangle_D25`（附加图形计算器，六个数全对） |

| 21 | Day26 异常（try / catch / finally + 自定义异常） | `week_4\Day26总\check\` | `checkD26.java`、`AgeException_D26.java`（主线原题）；`checkD26_A.java`、`MyArithmeticException.java`（A 题除法计算器）；`checkD26_B.java`、`BeyondnumException.java`（B 题成绩校验器） |
| 22 | Day27 递归（出口判断 · 打印型 / 布尔型 / 计数型） | `week_4\Day27总\check\` | `checkD27.java`（主线原题 `fact` / `fib` / `sum`）、`checkD27_B.java` + `checkD27_B2.java`（`maxOf` 两版）、`checkD27_C.java`（`printReverse` 倒序打印）、`checkD27_D.java`（`contains` 布尔型）、`checkD27_E.java`（`countTarget` 计数型） |
| 26 | Day32 字节流复制（`copy` + try-with-resources） | `week_5\Day32总\check\` | `checkD32.java`（11-13 补课，判 **C**——读写四行是给的）、`checkD32_B.java`（逐块比两文件，8 版判 C）、`checkD32_C.java`（多文件合并，判 B） |

**为什么第 18 题（Day23）放在 `Day24` 目录里：** week_4 没有单独的 Day23 目录，当时 Day23-24 是一起做的（`Day24` 里的 `Animal` / `Dog` / `Cat` / `Bird` 就是那两天的）。文件名 `checkD23` 自带区分。

**11-11 补课后又有 4 道通过**（原题号 1、2、3、4）：Day1 变量、Day2-3 Scanner、Day4 if/switch 三门，全部重出题做对后归档到上表。原题 `checkD1`（重复打印欢迎语、`long a1` 定义了没打印、变量名 a/a1/a2）和 `checkD4_B`（switch 半成品，`case 10:` 后面空的、没有输出）没改完，`checkD5`（Day5）当天跳过。

**11-11 补课第二批**（题号 8、9、10、11）也通过了：Day10-11 字符串、Day12 嵌套循环、Day13 排序。原题 `checkD10`（`s1[i] == "a"` 用 == 比 String，输出 0）和 `checkD12`（内层 `j = i` 写出倒三角）是错的旧版。**2026-11-11 决定留着当反面教材，已一并归档**：`checkD10.java` → `week_2\1012_Day10-11\check\`、`checkD12.java` → `week_2\1015_Day12-13\check\`。跟同目录下的 `_A`/`_B`/`_C`/`_D` 是同一道题的两种版本，文件名不带后缀的那个就是当时写错的。

**11-11 补课第三批**（题号 20）也通过了：Day25 抽象类 + 接口。第 20 题四判据全过（能 new Duck、d.speak+d.swim、多态走子类、`a.swim()` 编译错两条原文都对），附加的图形计算器六个数一个不差。**留下一条待复习**：接口方法的强转调用（他自己在那行标了「这个不太熟悉」）。

**11-11 补课第四批**（题号 21）也通过：Day26 异常。主线原题 `checkD26.java` 交上来时 catch / finally 全空、异常类没有构造方法，当天判 **C**；补两道加强题后立住 —— A 题除法计算器（`checkD26_A.java`：手动 throw + 两个 catch；把自建的 `ArithmeticException` 改名 `MyArithmeticException`，同名类会顶掉 `java.lang` 那个，`10/0` 根本不会被自己定义的类接住）、B 题成绩校验器（`checkD26_B.java`：数组 `{88,-5,60,120,90}`，循环在外、`try` 在内，`finally` 每轮打「审完」，5 个元素出 7 行、其中 2 行是拦截）。综合判 **B**。留下的洞「抛异常之后 `try` 后面的代码不会再执行」已记进 `E:\dsh\java\必背\待复习清单.md` 第 6 条，2026-11-18 复查。

**11-12 补课第五批**（题号 22）也通过：Day27 递归。主线原题 `checkD27.java` 交上来时 `fib` 是 `return 0`、`sum` 出口 `if (i <= 0) return arr[i];`，当天判 **C** —— 理由是 `sum` 出口改了小半夜：`<=` → `==` → `>` → `>=` 四次全在挪数字，没有一次在问「出口到底判断什么」。补三次加练后立住：`printReverse`（`void` 递归怎么停：`if (i < 0) return;`，顺带讲清 `i == 0` 会漏掉最后一格）、`contains`（**三版才对**：先写 `i <= 0` + `arr.length == 1` 特判，改 `length != 0` 仍挂 2 条，最后回到 `i < 0 || i >= arr.length` —— 正确的三行他自己先写过又注释掉了，这是当晚第 7 次「改边界不动机制」）、`countTarget`（一次写对，判 **A**）。

**第二轮补课结束：32 道里题号 1~22 全部通过，`test\src\` 已清空。** 剩下题号 23~32（第五、六周内容）等主线推到再考；到 11-13 为止 23~26 已补（23 泛型判 B、24 迭代器判 B、25 File 判 B、26 字节流判 A）。

---


---

## week_1：第一周（Day1 ~ Day7）

| 目录 | 日期 | 对应 Day | 文件数 |
|---|---|---|---|
| `1001_Day1` | 10-01 | Day1 | 3 |
| `1002_Day2-3` | 10-02 | Day2、Day3 | 7 |
| `1003_Day4` | 10-03 | Day4 | 9 |
| `1004_Day5` | 10-04 | Day5 | 8 |
| `1005_Day6` | 10-05 | Day6 | 2 |
| `1006_Day6A` | 10-06 | Day6A | 2 |
| `1007_Day7` | 10-07 | Day7 | 1 |
| `1008_Day7A` | 10-08 | Day7A | 1 |

---

## week_2：第二周（Day8 ~ Day14）

| 目录 | 日期 | 对应 Day | 文件数 |
|---|---|---|---|
| `1009_Day8` | 10-09 | Day8 | 6 |
| `1010_Day8-9` | 10-10 | Day8、Day9 | 6 |
| `1011_Day9-10` | 10-11 | Day9、Day10 | 3 |
| `1012_Day10-11` | 10-12 | Day10、Day11 | 6 |
| `1013_Day10-11` | 10-13 | Day10、Day11 | 3 |
| `1014_Day11-12` | 10-14 | Day11、Day12（含 Fix1/Fix2） | 9 |
| `1015_Day12-13` | 10-15 | Day12、Day13 | 9 |
| `1016_Day14` | 10-16 | Day14（含 Main1/Main2/MathDemo/PrimeDemo/ForWhileDemo） | 6 |
| `1017_Day14-15` | 10-17 | Day14、Day15 | 3 |

---

## week_3：第三周（Day15 ~ Day21）

| 目录 | 日期 | 对应 Day | 文件数 |
|---|---|---|---|
| `1018_Day15` | 10-18 | Day15（含 Book、Person） | 3 |
| `1019_Day15-16` | 10-19 | Day16（对象、构造方法、Book1、Student） | 7 |
| `1020_Day17` | 10-20 | Day17（方法传参、Scanner） | 3 |
| `1021_Day17-18` | 10-21 | Day18（foreach、split、Dogsort、ticketBought） | 14 |
| `1022_Day19` | 10-22 | Day19（HashMap 词频） | 5 |
| `1023_Day20` | 10-23 | Day20（HashSet 去重） | 1 |
| `1024_Day20A` | 10-24 | Day20A（首次登场） | 1 |
| `1025_Day21-22` | 10-25 | Day21（词频统计器）、Day22（继承：Animal/Dog/Cat/Bird） | 11 |

---

## week_4：第四周（Day22 ~ Day28）

| 目录 | 日期 | 内容 | 文件数 |
|---|---|---|---|
| `Day24` | 10-25 | 多态、抽象类、Money/Cash/Coin、Animal 系 | 18 |
| `Day25-发工资` | 10-27 | 接口 + 抽象类（Employee / Bonus / Clerk / Worker / Manager / Director / Day25B；2026-11-11 补课 9 个 check 文件） | 16 |
| `Day26总` | 10-28 | 下面五个子目录，见下 | 16 |
| `Day27总` | 10-29 | 递归（拆数字、汉诺塔、回文）；`check` 下 6 个查漏第 22 题文件 | 9 |
| `Day28总` | 10-31 | 旧书摊结算（Book / Day28 / Day28A / Student1 / README） | 5 |
| `day25` | — | **空目录**，可删 | 0 |
| `杂项` | 10-27 | `test.java`（二维数组验证） | 1 |

### `week_4\Day26总\` 内部

| 子目录 | 原来的名字 | 内容 |
|---|---|---|
| `Day26-0` | Day26-异常 | Day26 / Day26B / Day26C / ThrowDemo（异常） |
| `Day26-1` | Day26-2 | Student、week1_2（成绩单综合题） |
| `Day26-2` | Day26-3 | Book、Day26D（图书排行） |
| `Day26-3` | Day26-4 | Day26D、Student（图书排行改版） |
| `check` | 查漏第 21 题（2026-11-11 补课） | `checkD26.java`、`AgeException_D26.java`、`checkD26_A.java`、`MyArithmeticException.java`、`checkD26_B.java`、`BeyondnumException.java` —— 6 个文件，详见开头「check 归档」表 |

### `week_4\Day27总\` 内部

| 子目录 | 原来的名字 | 内容 |
|---|---|---|
| `Day27-0` | Day27 | `Day27.java`（拆数字） |
| `Day27-1` | Day27B | `Day27B.java`（汉诺塔） |
| `Day27-2` | Day27C | `Day27C.java`（回文） |
| `check` | 查漏第 22 题（2026-11-12 补课） | `checkD27.java`、`checkD27_B.java`、`checkD27_B2.java`、`checkD27_C.java`、`checkD27_D.java`、`checkD27_E.java` —— 6 个文件，详见开头「check 归档」表 |

---

## week_5：第五周（Day29 ~ ）

| 目录 | 日期 | 内容 | 文件数 |
|---|---|---|---|
| `Day29总` | 10-31 | 泛型 + 可变参数，下面分子目录，见下 | 4 |
| `Day30总` | 11-01 | 集合体系 + 迭代器，下面分子目录，见下 | 9 |
| `Day31总` | 11-02 | File 文件操作（元信息），下面分子目录，见下 | 8 |
| `Day32总` | 11-03 | 字节流 FileInputStream / FileOutputStream，下面分子目录，见下 | 6 |
| `Day33总` | 11-04 | 字符流 InputStreamReader / OutputStreamWriter / BufferedReader，下面分子目录，见下 | 2 |
| `Day34总` | 11-05 | 综合：词频统计器 v3（HashMap 计数 + 比较器排序 + 写回文件），下面分子目录，见下 | 1 |
| `订正` | 11-07 | 第五周补漏练习 A 组（集合排序）+ 11-12 三道加练，不分子目录，见下 | 5 |

### `week_5\Day29总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day29-0` | `Day29.java` | 泛型方法 `<T> void printAll(ArrayList<T>)`、可变参数 `int... nums` |
| `Day29-1` | `Day29A.java` | 通用小工具综合题（printAll / last / count / sum / average，12 行输出验收） |
| `check` | `checkD29.java` / `checkD29_A.java` | 11-12 补漏：第 23 题原题（`printAll(T... items)` + `first(List<T>)`，`List.of` 是照抄）一次过；加练「泛型工具箱」（`last` / `join` / `findIndex`）掉在 `join` 没用 `T...` 和 8 行全缺前缀上，但 `findIndex` 的 `==` 陷阱是他自己跑出来、自己改成 `equals` 的（`:30` 注释「看到输出错误改用equals」）。综合判 **B** |

### `week_5\Day30总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day30-0` | `Day30.java` | `Iterator` 删元素练习（抽奖池 `3 47 12 88 12 5 12 60` → `[47, 88, 60]`）；内含注释保留的倒序 for 替代方案 |
| `Day30-1` | `Day30A.java` + `Member.java` | 社团报名表综合题（去重按学号 / 迭代器删无效 / HashMap 数报名次数）；三组数据骨干逻辑全对 |
| `check` | 6 个文件 | 11-12 迭代器加练六道：`checkD30`（`contains` 去重 + Iterator 删长度<3）、`checkD30_A`（相邻去重 + 按序号删偶数位）、`checkD30_BC`（就地相邻去重 `last=s` + 删全部并计数）、`checkD30_D`（`limitRuns` 每段最多留 n 个，8/8，判 C——出口挪 4 次边界）、`checkD30_E`（删首尾，7/7，判 B——守卫只在进入时查一次）、`checkD30_F`（`rotateLeft` 左移 k 位，10/10，判 B——三轮提示才改对） |

### `week_5\Day31总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day31-0` | `Day31.java` | `File` 元信息：`listFiles()` 判 `null` 后 `return`、`mkdir`/`createNewFile`、`getName()+endsWith(".java")` 筛文件、计数器数 `.java` 个数、`delete()` 返回值验证（`if (note.delete())` 而不是先删再 println） |
| `Day31-1` | `Day31B.java` | 目录清单器综合题（11-03 凌晨写完，独立完成）：`listDir(String)` 拆成方法，三个前置守卫（不存在 / 不是目录 / `listFiles()` 返回 `null`）逐个 `return`，`isFile` 与 `isDirectory` 两个分支分别打「名字 类型 大小」，末行汇总 `共 N 项,其中文件 X 个,目录 Y 个`。五个调用把三条守卫 + 两个分类分支全跑过 |
| `check` | 6 个文件 | 11-13 File 加练六道：`checkD31`（`info` 元信息 + 列子项，判 B——`isFile()` 当「不存在」）、`checkD31_A`（`mkdirs` + 建删文件 + 数项，判 B——`createNewFile` 当建目录）、`checkD31_B`（递归数 `.java` 240 个，判 B——并列 `if` 改 `else if` 已堵坑）、`checkD31_C`（`deleteAll` 删整棵树 5/5，判 B）、`checkD31_D`（目录树缩进 + 三计数 + 汇总，2/5——没排序）、`checkD31_E`（递归搜索文件名，判 B——`static List` 没 `new`、递归被包在 `if` 里、每文件加两次；最后卡在「结果怎么交出去」，归档版仍返回 `List` 不打印） |

### `week_5\Day32总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day32-0` | `Day32.java` | 字节流：`write(int)` 只取低 8 位、`write(byte[])` 写一块、`FileOutputStream(..., true)` 追加对比默认清空；`read()` 逐字节递进、`-1` 判结尾、`(char) b` 转字符；两处 `try-with-resources`；`copy(from, to)` 用 1024 块 + `write(buf, 0, n)`，实测复制 30,784,597 字节的 flac，源与目标字节数一字节不差 |
| `check` | `checkD32.java` / `checkD32_B.java` / `checkD32_C.java` | 11-13 查漏第 26 题 + 两道加练（3 个文件）。**① `checkD32`**：`copy(String from, String to)` 用 1024 块循环 + `write(buf, 0, n)`，`try-with-resources` 已写对、补上中间读写四行。实测复制 546,985 字节照片 → 逐字节相等、图片能打开；边界 0/1/1024/1025/1400/2048/100000 七组全等。**判 C**（四行读写是从零讲的，他只补了 `main` 和路径）。**② `checkD32_B`**：`isCompareTrue` 逐块比两个文件，8 个版本、6 次提示才过 11/11（`bufA.equals(bufB)` 比引用、`read` 写进 `for`、`nA != nB` 放错层三次）；独立想出来的只有「`i` 从 0 走到 `nA`」。**判 C**。**③ `checkD32_C`**：`method1(String[] paths, String outPath)` 多文件首尾相接，第一版两个流位置就放对了（`out` 在 `for` 外、`in` 在 `for` 内），但 `while` 里少了 `n = in.read(buf)` → 死循环写出 30,765,098 字节；补上后再把输入流挪进 `try(...)`，8/8 全过（含隐藏判据「覆盖已有内容」）。**判 B** |
| `Day32-1` | `Day32A.java` | 文件备份器综合题（11-03 下午，题目给出、含三处预警坑）：`backup(String fromDir, String toDir, String suffix)` 拆成方法，目标目录不存在先 `mkdir`；遍历后 `isFile() && endsWith(suffix)` 才走复制分支，`isDirectory` 算子目录、`!endsWith` 算后缀不符；双层 `try-with-resources` 内 2048 块循环 `write(buf, 0, n)`；四个计数器在 `while` 外（复制完成后才加）。实测 a.txt/b.txt/c.txt 三文件 `cmp` 逐字节一致，汇总 `共 3 个文件, 3534 字节`。**已知瑕疵（未改，不影响功能）**：L44-49 的 `OK/False` 打印写在循环末尾而非复制分支内，导致 `d.java`、`sub` 两个跳过项也各打一行 `False`，与题目「跳过的只记个数不打印」有出入 |

### `week_5\Day33总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day33-0` | `Day33.java` | 字符流三层结构：`BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/cn.txt"), StandardCharsets.UTF_8))` 写三行中文、`newLine()` 换行；`BufferedReader(new InputStreamReader(new FileInputStream(...), UTF_8))` 逐行 `readLine()` 读回，序号 `n + ". " + line` **只在打印时加、不写进文件**（文件 70 字节原文三行，无 `1.` 前缀）；末尾用 `FileInputStream` 逐字节 `read()` + `(char)` 再读一遍，亲眼看 UTF-8 中文被拆成 `æçç¹å«ç±ä½` 的乱码。追加实验做完后已删掉 `true`，恢复覆盖写 |
| `Day33-1` | `Day33B.java` | 文本清理器综合题（11-04，题目在 `E:\dsh\java\Day33B-文本清理器.md`）：`clean(String fromPath, String toPath)` 拆成方法，双层 `try-with-resources` 同时开读、写两个流（UTF-8）；`readLine()` 读到 `null` 结束，`strip()` 去两头空白，`isEmpty()` 判空行后 `continue`；`bw.write(line)` 紧跟 `bw.newLine()` 一行一行写出；三个计数器 `n` / `emp` / `wri` 分别在读完一行、判为空行、写完一行时加。实测题目给的 9 行测试数据 → 原文 9 / 清掉空行 4 / 写出 5，`clean.txt` 5 行无空行、无首尾空格，`dirty.txt` 跑前跑后都是 94 字节（没被覆盖）。测试数据里含一个「只有一个制表符」的行，`strip + isEmpty` 正确识别成空行 |

### `week_5\Day34总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day34-0` | `Day34.java` | 词频统计器 v3（11-05，教材 Day34 综合）：`BufferedReader` 逐行 `readLine()` → `toLowerCase().split(" +")`（正则 `+` 吃掉连续空格，写 `split(" ")` 遇双空格会切出空串）→ `HashMap<String,Integer>` 计数 → `new ArrayList<>(hm.keySet())` **建在读完整个文件之后**（建在 `while` 前拿到的是空名单）→ `Collections.sort(list, (a, b) -> hm.get(b) - hm.get(a))` 按次数降序 → `BufferedWriter` 写 `data/report.txt`。实测文章两行 → the 4 / on 2 / sat 2 / 其余各 1，单词总数 12、不同 7、最长 elephant，`report.txt` 178 字节。**已知瑕疵（未改，不影响数据）**：标题写成 `=== 词频统计 ===`（教材要求 `=== 词频排行 ===`）；排行与 `=== 总计 ===` 之间缺一个空行 |



### `week_5\订正\` 内部

这里是**补漏练习**的成品，不按 `DayNN` 编号，因为是回头补第五周欠的账（题目在 `E:\dsh\java\第五周补漏练习.md`）。

| 文件 | 内容 |
|---|---|
| `Arr.java` | 补漏 A1「排行榜」：`HashMap` 计数 → `new ArrayList<>(count.keySet())` → `Collections.sort` 两段比较器（`int d1 = count.get(b) - count.get(a); if (d1 != 0) return d1; return a.compareTo(b);`）→ 带序号打印。实测输出 `the 4 / mat 3 / on 2 / sat 2 / cat 1 / dog 1 / elephant 1`，四条判据全过。**踩过的坑**：`new ArrayList<>(count.keySet())` 最初写在所有 `put` 之前，拿到空名单，排完还是 `[]`，`get(0)` 直接 `IndexOutOfBoundsException: Index 0 out of bounds for length 0`——这是他**第三次**同款「东西放错流程位置」的错（前两次：Day32A 计数器放进 `while`、Day34 `a1s` 建在 `while` 之前）。循环上界也从 `count.size()` 改成 `ar.size()`（循环哪个就用哪个的 size） |
| `CityRank.java` | 补漏 A3「城市销量榜」：同一套结构换数据（`shanghai 12 / beijing 12 / zhengzhou 7 / wuhan 7 / xian 3 / chengdu 3`，**三组全是并列**，专治「只写一条规则」），比较器两段写对。**踩过的坑**：排序六行全对，但序号硬编码成 `"1. "`，打出六个 `1.`——这是他**第三次「算对了、报告错了」**（前两次：practice1 打印被减到 0 的 `n`、Day32B 打印一堆 `False`）。改成 `(i + 1) + ". "` 后正确 |
| `checkD29.java` | 补漏 A2「按长度排」：`Collections.sort` 比较器只比长度（`b.length() - a.length()`），**同长度没排**——`stream/reader`、`java/file` 全是原数组顺序（稳定排序在比出 0 时不动）。当时我那 4 条判据全过，是我判据漏了二级。指出后他补 `if (d1 == 0) return a.compareTo(b);`，而且是**反过来写**（`d1 == 0` 提前返回），逻辑等价。实测 `[buffered, reader, stream, file, java, io, a]`。判 **B** |
| `checkD29_A.java` | 加练「成绩单排名」：排序 + 名次 + 最高分人数。比较器先写 `Integer.parseInt(b.substring(3))`——**按位置切**，名字三个字就炸（实测 `"欧阳修:90".substring(3)` = `:90`），改成 `b.substring(b.indexOf(":") + 1)` 才对；`max` 方法用三个 for 求最大值和人数。他第一版还把分数预先塞进平行数组 `int[] a2` 想按下标配对，`a2` 不随 `a1` 交换 → 压根没跑起来。实测 7 行排行榜 + `最高分 100 分，共 1 人`。判 **B** |
| `checkD29_B.java` | 「两班名单」（HashSet 交集/差集/计数）草稿，**空壳未做**——只有 `clts` 方法签名和空的 main，随批留档 |

---

## week_6：第六周（Day36 ~ ）

| 目录 | 日期 | 内容 | 文件数 |
|---|---|---|---|
| `杂项-0` | 11-07 | 第六周开课前的一次性收纳：必补八条第 1~4 条的练习 + 打包用的 Day34 副本 + 清单，下面见下 | 5 |
| `Day36总` | 11-07 | equals / hashCode / toString 三件套实战：判等 + 哈希 + 集合去重 + 打印，下面分子目录，见下 | 2 |
| `Day37总` | 11-08 | 第一个碰真实文件系统的程序：`File` + `FilenameFilter` 匿名内部类筛 `.java`，判空守卫顺序 + `File` 双参构造取真实字节数，下面分子目录，见下 | 2 |
| `Day38总` | 11-09 | Lambda 与函数式接口入门：Runnable / Comparator / Consumer / 方法引用 / `forEach` / 自写 `map`+`filter`，下面分子目录，见下 | 4 |
| `Day39总` | 11-10 | Stream 入门第一课：`filter` / `map` / `sorted` / `collect` / `groupingBy`，把前一天的 Lambda 换成流水线写法，下面分子目录，见下 | 1 |

### `week_6\杂项-0\` 内部

| 文件 | 内容 |
|---|---|
| `Day34.java` | 从 `week_5\Day34总\Day34-0` 拿回来打包 jar 用的副本；`M1("data/archive.txt","data/report.txt")` 词频统计器 v3 |
| `Dog1.java` | 必补八条第 4 条：`equals` 四步（`this==o` / `!instanceof` / 强转 / 逐字段）+ `Objects.hash(name, age)`。12 项测试全过：HashSet 去重剩 2 只、`contains` 新建同款返回 true、两个 null 字段不崩、1000 次放入只剩 5 只 |
| `Eight_hole.java` | 必补八条第 1~3 条合集：`Hole_one()` 用 StringBuilder 拼一万个数字（末尾 `deleteCharAt` 去掉多余逗号）、`check(int)` 抛自定义异常并 try-catch、`main` 两者都调 |
| `AgeException.java` | 第 3 条自定义异常：`extends Exception` + `super(msg)`，五处拼写（文件名/类名/throws/new/catch）一致 |
| `META-INF/MANIFEST.MF` | IDEA 打 jar 用的清单（44 字节）：`Main-Class: Day34` |

### `week_6\Day36总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day36-0` | `Day36.java` + `Dog2.java` | `equals` / `hashCode` / `toString` 三件套。`Dog2`：`equals` 四步（`this==o` / `!(o instanceof Dog2)` / 强转 / `d.age == age && Objects.equals(name, d.name)`）、`hashCode` 用 `Objects.hash(age, name)`、`toString` 输出 `Dog2{name= 旺财, age= 3}`。`Day36`：`type1(Dog2, Dog2)` 打印相同/不同 **并打印两边 hashCode**；`type2(Dog2...)` 用 `HashSet` 数去重后剩几只（可变参数 + 泛型集合）。三组实跑：① `旺财3` 对 `旺财3` → 一样、哈希 `846470 vs 846470`、三只 `旺财3/旺财3/小黑5` 去重剩 **2 只** ② `旺财3` 对 `小黑5` → 不一样、哈希 `846470 vs 772350`、三只全不同剩 **3 只** ③ `旺财3` 对 `旺财9` → 不一样、哈希 `846470 vs 846656`、剩 **1 只**（第 3 组证明 `age` 真的参与比较，不是只比名字） |

### `week_6\Day37总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day37-0` | `Day37.java` | 第一个碰真实文件系统的程序。`listJava(String dirPath)`：`File` 对象 + `FilenameFilter` 匿名内部类只筛 `.java`，`dir1.list(...)` 返回 `String[]` 文件名数组。两个守卫顺序固定 —— 先 `names == null`（目录不存在时 `list()` 返回 null，对 null 取 `.length` 当场 NPE），后 `names.length == 0`；顺序反了第一个判空就是死代码，整个程序靠 `catch` 兜着跑。再用 `File(File parent, String child)` 双参构造 `new File(dir1, names[i])` 拼完整路径，打印 `getName()` + `length()` —— `length()` 加在目录上返回的是目录项本身（NTFS 一个簇 = 4096），加在文件上才是真实字节数。五场景实跑：`archive\week_4\Day24` → 18 行 `名字 字节数`；`archive\week_6\杂项-0` → 4 行且不含 `META-INF`；`data` → 空数组；`C:\no\such\dir` → null；传文件 `src\Day37.java` → null。另含两个能跑的匿名 `Comparator`（长度升序 / 字母倒序），Lambda 版本按要求跳过未写 |
| `Day37-1` | `Day37L.java` | 同一个筛 `.java` 的功能写两遍并排：`a1` 用 Lambda 一行 `dir1.list((folder, name) -> name.endsWith(".java"))`，`a2` 用 `new FilenameFilter(){ @Override public boolean accept(File dir, String name){ return name.endsWith(".java"); } }`。这是 `FilenameFilter` 只有 **1 个抽象方法**的直接验证 —— 单抽象方法接口（函数式接口）才能写成 Lambda。两版都用 `Arrays.toString(names)` 打印（数组没重写 `toString`，直接打会得到 `[Ljava.lang.String;@77459877` 这种哈希，示意值每次不同），实测两行输出完全一致 `[AgeException.java, Day34.java, Dog1.java, Eight_hole.java]`，都不含 `META-INF`。省掉的是整层方法外壳：`new FilenameFilter()` / `@Override` / 方法签名 / `return` / `{ }`，6 行变 1 行。**遗留**：L1 `import java.awt.*;` 与程序无关，两次清 import 都没删 |

### `week_6\Day38总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day38-0` | `Day38.java` | 教材三道动手任务。① `Runnable r1 = () -> {...}` 零参数 Lambda 打印「我是一句话」；② `Comparator<String> com = (String a, String b) -> { return b.length() - a.length(); }` 长度**倒序**（`b - a` 才是倒序，`a - b` 是升序），`li.sort(com)` 后输出 `[akdghia, 192371, 43]`；③ `li.forEach(System.out::println)` 方法引用打印。**L23-27 是一段没跑通的残留**：往 `List<Runnable>` 里塞了三个 Lambda，却用 `forEach(System.out::println)` 输出 —— `println` 收到的是 `Runnable` 对象本身，打出来的是 `Day38$$Lambda/0x...@19469ea2` 这种哈希（示意值，每次运行都不同），三个 Lambda 一个都没执行。要执行得写 `li1.forEach(Runnable::run)` 或 `for (Runnable r : li1) r.run();` |
| | `Day38A.java` | 自写泛型方法 `public static <T> void runAll(List<T> data, Consumer<T> action)`：`for (T x : data) action.accept(x);`。`Consumer` 的抽象方法只有 `void accept(T)`，`action.accept(x)` 就是「把 x 交给这段逻辑」。main 里同一个 `runAll` 连调三次、**一次没改代码**：① `s -> System.out.println("处理: " + s)` → `处理: 张三 / 李四 / 王五` ② `System.out::println` → `张三 / 李四 / 王五` ③ `x -> System.out.println(x * x)` → `1 4 9 16`。第三条是这次的关键：Lambda 体是**一个动作**，要打印平方就在里面算完直接 println，不能 `x = x * x`（赋值不留结果） |
| | `Day38B.java` | 二级排序 + `continue`。数据 `java/io/stream/file/buffered/a/reader/go/code`（长度 4/2/6/4/8/1/6/2/4）。`Collections.sort(words, new Comparator<String>(){...})` 里 `if (o1.length() == o2.length()) return o1.compareTo(o2); return o2.length() - o1.length();` —— 长度降序 + 同长字母升序，`if` 那行是真会执行的（`java`/`file` 都是 4，`stream`/`reader` 都是 6）。实跑：`原始：[java, io, stream, file, buffered, a, reader, go, code]` → `排序后：[buffered, reader, stream, code, file, java, go, io, a]`。后半段 `for (String x : words) { if (x.length() < 3) continue; ... count++; }` 打印 6 个词、`剩余 6 个`（`a`/`go`/`io` 三个被跳过），`count++` 写在 `println` 之后才数得对。**这是二级排序第一次独立写对**（前一周补漏 A2 那道还是空的） |
| | `Day38C.java` | 自己实现 `map` 和 `filter` 两个泛型方法，是这一周唯一从零写出函数式工具的一次。`public static <T,R> List<R> map(List<T> data, Function<T,R> f)`：先 `new ArrayList<>()` 造盒子，`for (T x : data) l1.add(f.apply(x));`，`Function` 的抽象方法只有 `R apply(T)`。`public static <T> List<T> filter(List<T> data, Predicate<T> p)`：结构完全一样，只差一个 `if (p.test(x)) result.add(x);` —— `Predicate` 的抽象方法只有 `boolean test(T)`，装的是 `x` 本身而不是 `p.test(x)`。四步实跑：① `map(names, s -> s.length())` → `[1, 2, 3, 4]` ② `filter(names, s -> s.length() >= 3)` → `[王五五, 赵六六六]` ③ `map(longNames, String::length)` → `[3, 4]` ④ 方法引用对 `names` 再跑一次 → 按设计应为 `[1, 2, 3, 4]`，**归档版本里这一行被 ③ 顶掉了，未单独打印**（`String::length` 这个用法本身在 ③ 里已验证）。L27 旁边留着他自己的注释 `//忘记结构`，L31 从"再调一次 filter"改成"复用 longNames"，因为实测 4 个元素时单次 `filter` 里的 Lambda 要跑 4 次，两处各写一次就是 8 次 —— 中间结果复用两次以上就该存变量 |

### `week_6\Day39总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day39-0` | `Day39.java` | Stream 入门，五个方法把同一份数据 `java/io/stream/file/buffered/a/reader/go/code`（长度 4/2/6/4/8/1/6/2/4）走五遍。`a0` 返回 `List<Integer>`：`filter(s -> s.length() >= 3).map(String::length).collect(Collectors.toList())` → `[4, 6, 4, 8, 6, 4]`；`a1` 长度≥4 且按长度**降序**：`filter(...).sorted(Comparator.comparingInt(String::length).reversed())` → `[buffered, stream, reader, java, file, code]`（同长度的保持原始顺序，因为 `sorted` 是稳定排序，没加 `thenComparing`）；`a2` 全大写 `map(String::toUpperCase)`；`a3` `filter(s -> s.startsWith("r")).size()` → `1`（只有 reader）；`a4` `groupingBy(String::length, Collectors.counting())` → `{1=1, 2=2, 4=3, 6=2, 8=1}`（**值类型是 Long 不是 Integer**，写成 `Map<Integer,Integer>` 编译不过）。五段实跑全对，编译零警告。L41-51 是他自己注释掉的一段练习残留，原话「这些全部是用来练习的 作废但是我不想删除」——里面的六行（`sorted()` / `sorted(reversed)` / `count()` / `anyMatch` / `limit(3)+joining` / `groupingBy`）都已单独跑通，只是没留输出 |

---

## 一条规矩

**别在这个目录里直接改代码。** 这里的东西已经结课了。

要重新练，就复制一份到 `src\` 再改。

**一组互相引用的类必须整组复制**（比如 Animal/Dog/Cat 要一起拿走，只搬一个会编译不过）。

---

## 冷备份

**桌面上还有一个 `往期训练Java项目\`**，是搬家前的原始副本，内容跟这里的 week_1~week_3 基本重合。

**平时用不着它** —— 只有在仓库里找不到某个老文件时才去翻。
