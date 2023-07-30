{\rtf1\ansi\ansicpg1252\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue255;\red255\green255\blue255;\red0\green0\blue0;
\red32\green108\blue135;\red101\green76\blue29;\red0\green0\blue109;\red15\green112\blue1;\red157\green0\blue210;
\red19\green118\blue70;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c100000;\cssrgb\c100000\c100000\c100000;\cssrgb\c0\c0\c0;
\cssrgb\c14902\c49804\c60000;\cssrgb\c47451\c36863\c14902;\cssrgb\c0\c6275\c50196;\cssrgb\c0\c50196\c0;\cssrgb\c68627\c0\c85882;
\cssrgb\c3529\c52549\c34510;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 // Time Complexity : O(1)\
// Space Complexity : O(N)\
// Did this code successfully run on Leet code : Yes\
// Any problem you faced while coding this : No\
class\cf0 \strokec4  \cf5 \strokec5 MinStack\cf0 \strokec4 :\cb1 \
\
\pard\pardeftab720\partightenfactor0
\cf0 \cb3     \cf2 \strokec2 def\cf0 \strokec4  \cf6 \strokec6 __init__\cf0 \strokec4 (\cf7 \strokec7 self\cf0 \strokec4 ):\cb1 \
\cb3         \cf8 \strokec8 #create two empty stacks for stack elements and ,min value stack and initilize min to the minimum value\cf0 \cb1 \strokec4 \
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .stack = []\cb1 \
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .minStack = []\cb1 \
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .min = \cf5 \strokec5 int\cf0 \strokec4 (sys.maxsize)\cb1 \
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .minStack.append(\cf2 \strokec2 self\cf0 \strokec4 .min)\cb1 \
\
\cb3     \cf2 \strokec2 def\cf0 \strokec4  \cf6 \strokec6 push\cf0 \strokec4 (\cf7 \strokec7 self\cf0 \strokec4 , \cf7 \strokec7 val\cf0 \strokec4 : \cf5 \strokec5 int\cf0 \strokec4 ) -> \cf2 \strokec2 None\cf0 \strokec4 :\cb1 \
\cb3         \cf8 \strokec8 # Min value is updated if the value is less than or equal to current min value\cf0 \cb1 \strokec4 \
\cb3         \cf8 \strokec8 #for pushing an elemnt is added to stack [] and current min value is added to the min stack, this helps to track min value during pop operation\cf0 \cb1 \strokec4 \
\cb3         \cf9 \strokec9 if\cf0 \strokec4  val <= \cf2 \strokec2 self\cf0 \strokec4 .min:\cb1 \
\cb3             \cf2 \strokec2 self\cf0 \strokec4 .min = val\cb1 \
\
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .minStack.append(\cf2 \strokec2 self\cf0 \strokec4 .min)\cb1 \
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .stack.append(val)\cb1 \
\
\cb3     \cf2 \strokec2 def\cf0 \strokec4  \cf6 \strokec6 pop\cf0 \strokec4 (\cf7 \strokec7 self\cf0 \strokec4 ) -> \cf2 \strokec2 None\cf0 \strokec4 :\cb1 \
\cb3         \cf8 \strokec8 #Elemnt is popped from the stack and minStack\cf0 \cb1 \strokec4 \
\cb3         \cf8 \strokec8 # if the min value is equal to the popped element, change the min value to last min value from minstack[]\cf0 \cb1 \strokec4 \
\cb3         popped = \cf2 \strokec2 self\cf0 \strokec4 .stack.pop()\cb1 \
\cb3         \cf2 \strokec2 self\cf0 \strokec4 .minStack.pop()\cb1 \
\cb3         \cf9 \strokec9 if\cf0 \strokec4  popped == \cf2 \strokec2 self\cf0 \strokec4 .min:\cb1 \
\cb3             \cf2 \strokec2 self\cf0 \strokec4 .min = \cf2 \strokec2 self\cf0 \strokec4 .minStack[-\cf10 \strokec10 1\cf0 \strokec4 ]\cb1 \
\
\cb3     \cf2 \strokec2 def\cf0 \strokec4  \cf6 \strokec6 top\cf0 \strokec4 (\cf7 \strokec7 self\cf0 \strokec4 ) -> \cf5 \strokec5 int\cf0 \strokec4 :\cb1 \
\cb3         \cf8 \strokec8 # retur the top element in the stack[]\cf0 \cb1 \strokec4 \
\cb3         \cf9 \strokec9 return\cf0 \strokec4  \cf2 \strokec2 self\cf0 \strokec4 .stack[-\cf10 \strokec10 1\cf0 \strokec4 ]\cb1 \
\cb3         \cb1 \
\cb3     \cf2 \strokec2 def\cf0 \strokec4  \cf6 \strokec6 getMin\cf0 \strokec4 (\cf7 \strokec7 self\cf0 \strokec4 ) -> \cf5 \strokec5 int\cf0 \strokec4 :\cb1 \
\cb3         \cf8 \strokec8 # return the value of min variable\cf0 \cb1 \strokec4 \
\cb3         \cf9 \strokec9 return\cf0 \strokec4  \cf2 \strokec2 self\cf0 \strokec4 .min\cb1 \
\cb3         \cb1 \
\
\
\pard\pardeftab720\partightenfactor0
\cf8 \cb3 \strokec8 # Your MinStack object will be instantiated and called as such:\cf0 \cb1 \strokec4 \
\cf8 \cb3 \strokec8 # obj = MinStack()\cf0 \cb1 \strokec4 \
\cf8 \cb3 \strokec8 # obj.push(val)\cf0 \cb1 \strokec4 \
\cf8 \cb3 \strokec8 # obj.pop()\cf0 \cb1 \strokec4 \
\cf8 \cb3 \strokec8 # param_3 = obj.top()\cf0 \cb1 \strokec4 \
\cf8 \cb3 \strokec8 # param_4 = obj.getMin()\cf0 \cb1 \strokec4 \
}