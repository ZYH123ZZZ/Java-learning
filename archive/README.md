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
├── week_2\   第二周  Day8  ~ Day14     9 个目录   40 个文件
├── week_3\   第三周  Day15 ~ Day21     8 个目录   45 个文件
├── week_4\   第四周  Day22 ~ Day28     7 个目录   44 个文件
├── week_5\   第五周  Day29 ~ Day34    6 个目录   12 个文件
└── week_6\   第六周  Day36 ~          1 个目录    5 个文件
```

**分周规则：按目录名里最小的那个 Day 号归周。**

比如 `1017_Day14-15` 归 `week_2`（从 Day14 开始做的），`1025_Day21-22` 归 `week_3`。

---

## week_1：第一周（Day1 ~ Day7）

| 目录 | 日期 | 对应 Day | 文件数 |
|---|---|---|---|
| `1001_Day1` | 10-01 | Day1 | 1 |
| `1002_Day2-3` | 10-02 | Day2、Day3 | 4 |
| `1003_Day4` | 10-03 | Day4 | 8 |
| `1004_Day5` | 10-04 | Day5 | 8 |
| `1005_Day6` | 10-05 | Day6 | 1 |
| `1006_Day6A` | 10-06 | Day6A | 2 |
| `1007_Day7` | 10-07 | Day7 | 1 |
| `1008_Day7A` | 10-08 | Day7A | 1 |

---

## week_2：第二周（Day8 ~ Day14）

| 目录 | 日期 | 对应 Day | 文件数 |
|---|---|---|---|
| `1009_Day8` | 10-09 | Day8 | 5 |
| `1010_Day8-9` | 10-10 | Day8、Day9 | 5 |
| `1011_Day9-10` | 10-11 | Day9、Day10 | 3 |
| `1012_Day10-11` | 10-12 | Day10、Day11 | 3 |
| `1013_Day10-11` | 10-13 | Day10、Day11 | 3 |
| `1014_Day11-12` | 10-14 | Day11、Day12（含 Fix1/Fix2） | 9 |
| `1015_Day12-13` | 10-15 | Day12、Day13 | 3 |
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
| `Day25-发工资` | 10-27 | 接口 + 抽象类（Employee / Bonus / Clerk / Worker / Manager / Director / Day25B） | 7 |
| `Day26总` | 10-28 | 下面四个子目录，见下 | 10 |
| `Day27总` | 10-29 | 递归（拆数字、汉诺塔、回文） | 3 |
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

---

## week_5：第五周（Day29 ~ ）

| 目录 | 日期 | 内容 | 文件数 |
|---|---|---|---|
| `Day29总` | 10-31 | 泛型 + 可变参数，下面分子目录，见下 | 2 |
| `Day30总` | 11-01 | 集合体系 + 迭代器，下面分子目录，见下 | 3 |
| `Day31总` | 11-02 | File 文件操作（元信息），下面分子目录，见下 | 2 |
| `Day32总` | 11-03 | 字节流 FileInputStream / FileOutputStream，下面分子目录，见下 | 2 |
| `Day33总` | 11-04 | 字符流 InputStreamReader / OutputStreamWriter / BufferedReader，下面分子目录，见下 | 2 |
| `Day34总` | 11-05 | 综合：词频统计器 v3（HashMap 计数 + 比较器排序 + 写回文件），下面分子目录，见下 | 1 |

### `week_5\Day29总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day29-0` | `Day29.java` | 泛型方法 `<T> void printAll(ArrayList<T>)`、可变参数 `int... nums` |
| `Day29-1` | `Day29A.java` | 通用小工具综合题（printAll / last / count / sum / average，12 行输出验收） |

### `week_5\Day30总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day30-0` | `Day30.java` | `Iterator` 删元素练习（抽奖池 `3 47 12 88 12 5 12 60` → `[47, 88, 60]`）；内含注释保留的倒序 for 替代方案 |
| `Day30-1` | `Day30A.java` + `Member.java` | 社团报名表综合题（去重按学号 / 迭代器删无效 / HashMap 数报名次数）；三组数据骨干逻辑全对 |

### `week_5\Day31总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day31-0` | `Day31.java` | `File` 元信息：`listFiles()` 判 `null` 后 `return`、`mkdir`/`createNewFile`、`getName()+endsWith(".java")` 筛文件、计数器数 `.java` 个数、`delete()` 返回值验证（`if (note.delete())` 而不是先删再 println） |
| `Day31-1` | `Day31B.java` | 目录清单器综合题（11-03 凌晨写完，独立完成）：`listDir(String)` 拆成方法，三个前置守卫（不存在 / 不是目录 / `listFiles()` 返回 `null`）逐个 `return`，`isFile` 与 `isDirectory` 两个分支分别打「名字 类型 大小」，末行汇总 `共 N 项,其中文件 X 个,目录 Y 个`。五个调用把三条守卫 + 两个分类分支全跑过 |

### `week_5\Day32总\` 内部

| 子目录 | 文件 | 内容 |
|---|---|---|
| `Day32-0` | `Day32.java` | 字节流：`write(int)` 只取低 8 位、`write(byte[])` 写一块、`FileOutputStream(..., true)` 追加对比默认清空；`read()` 逐字节递进、`-1` 判结尾、`(char) b` 转字符；两处 `try-with-resources`；`copy(from, to)` 用 1024 块 + `write(buf, 0, n)`，实测复制 30,784,597 字节的 flac，源与目标字节数一字节不差 |
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



---

## week_6：第六周（Day36 ~ ）

| 目录 | 日期 | 内容 | 文件数 |
|---|---|---|---|
| `杂项-0` | 11-07 | 第六周开课前的一次性收纳：必补八条第 1~4 条的练习 + 打包用的 Day34 副本 + 清单，下面见下 | 5 |

### `week_6\杂项-0\` 内部

| 文件 | 内容 |
|---|---|
| `Day34.java` | 从 `week_5\Day34总\Day34-0` 拿回来打包 jar 用的副本；`M1("data/archive.txt","data/report.txt")` 词频统计器 v3 |
| `Dog1.java` | 必补八条第 4 条：`equals` 四步（`this==o` / `!instanceof` / 强转 / 逐字段）+ `Objects.hash(name, age)`。12 项测试全过：HashSet 去重剩 2 只、`contains` 新建同款返回 true、两个 null 字段不崩、1000 次放入只剩 5 只 |
| `Eight_hole.java` | 必补八条第 1~3 条合集：`Hole_one()` 用 StringBuilder 拼一万个数字（末尾 `deleteCharAt` 去掉多余逗号）、`check(int)` 抛自定义异常并 try-catch、`main` 两者都调 |
| `AgeException.java` | 第 3 条自定义异常：`extends Exception` + `super(msg)`，五处拼写（文件名/类名/throws/new/catch）一致 |
| `META-INF/MANIFEST.MF` | IDEA 打 jar 用的清单（44 字节）：`Main-Class: Day34` |

---

## 一条规矩

**别在这个目录里直接改代码。** 这里的东西已经结课了。

要重新练，就复制一份到 `src\` 再改。

**一组互相引用的类必须整组复制**（比如 Animal/Dog/Cat 要一起拿走，只搬一个会编译不过）。

---

## 冷备份

**桌面上还有一个 `往期训练Java项目\`**，是搬家前的原始副本，内容跟这里的 week_1~week_3 基本重合。

**平时用不着它** —— 只有在仓库里找不到某个老文件时才去翻。
