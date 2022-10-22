{\rtf1\ansi\ansicpg1252\cocoartf2636
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red15\green112\blue1;\red255\green255\blue255;\red0\green0\blue0;
\red0\green0\blue255;\red32\green108\blue135;\red0\green0\blue109;\red157\green0\blue210;\red101\green76\blue29;
\red19\green118\blue70;}
{\*\expandedcolortbl;;\cssrgb\c0\c50196\c0;\cssrgb\c100000\c100000\c100000;\cssrgb\c0\c0\c0;
\cssrgb\c0\c0\c100000;\cssrgb\c14902\c49804\c60000;\cssrgb\c0\c6275\c50196;\cssrgb\c68627\c0\c85882;\cssrgb\c47451\c36863\c14902;
\cssrgb\c3529\c52549\c34510;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 //time complexity is O(1)\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2 //space complexity is O(N)\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2 //able to submit the in leetcode\cf0 \cb1 \strokec4 \
\pard\pardeftab720\partightenfactor0
\cf5 \cb3 \strokec5 class\cf0 \strokec4  \cf6 \strokec6 MinStack\cf0 \strokec4  \{\cb1 \
\pard\pardeftab720\partightenfactor0
\cf0 \cb3     \cf6 \strokec6 Stack\cf0 \strokec4 <\cf6 \strokec6 int\cf0 \strokec4 []> \cf7 \strokec7 st\cf0 \strokec4  = \cf8 \strokec8 new\cf0 \strokec4  \cf6 \strokec6 Stack\cf0 \strokec4 <>();\cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf9 \strokec9 MinStack\cf0 \strokec4 () \{\cb1 \
\cb3         \cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 void\cf0 \strokec4  \cf9 \strokec9 push\cf0 \strokec4 (\cf6 \strokec6 int\cf0 \strokec4  \cf7 \strokec7 val\cf0 \strokec4 ) \{\cb1 \
\cb3         \cf8 \strokec8 if\cf0 \strokec4 (\cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 isEmpty\cf0 \strokec4 ())\cb1 \
\cb3         \{\cb1 \
\cb3             \cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 push\cf0 \strokec4 ((\cf8 \strokec8 new\cf0 \strokec4  \cf6 \strokec6 int\cf0 \strokec4 []\{val, val\}));\cb1 \
\cb3         \}\cb1 \
\cb3         \cf8 \strokec8 else\cf0 \strokec4 \{\cb1 \
\cb3             \cf6 \strokec6 int\cf0 \strokec4 [] \cf7 \strokec7 temp\cf0 \strokec4  = \cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 peek\cf0 \strokec4 ();\cb1 \
\cb3             \cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 push\cf0 \strokec4 (\cf8 \strokec8 new\cf0 \strokec4  \cf6 \strokec6 int\cf0 \strokec4 [] \{val, \cf7 \strokec7 Math\cf0 \strokec4 .\cf9 \strokec9 min\cf0 \strokec4 (val, temp[\cf10 \strokec10 1\cf0 \strokec4 ])\});\cb1 \
\cb3         \}\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 void\cf0 \strokec4  \cf9 \strokec9 pop\cf0 \strokec4 () \{\cb1 \
\cb3         \cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 pop\cf0 \strokec4 ();\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 int\cf0 \strokec4  \cf9 \strokec9 top\cf0 \strokec4 () \{\cb1 \
\cb3         \cf8 \strokec8 return\cf0 \strokec4  \cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 peek\cf0 \strokec4 ()[\cf10 \strokec10 0\cf0 \strokec4 ];\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 int\cf0 \strokec4  \cf9 \strokec9 getMin\cf0 \strokec4 () \{\cb1 \
\cb3         \cf8 \strokec8 return\cf0 \strokec4  \cf7 \strokec7 st\cf0 \strokec4 .\cf9 \strokec9 peek\cf0 \strokec4 ()[\cf10 \strokec10 1\cf0 \strokec4 ];\cb1 \
\cb3     \}\cb1 \
\cb3 \}\cb1 \
\
\pard\pardeftab720\partightenfactor0
\cf2 \cb3 \strokec2 /**\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  * Your MinStack object will be instantiated and called as such:\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  * MinStack obj = new MinStack();\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  * obj.push(val);\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  * obj.pop();\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  * int param_3 = obj.top();\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  * int param_4 = obj.getMin();\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2  */\cf0 \cb1 \strokec4 \
}