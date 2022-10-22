{\rtf1\ansi\ansicpg1252\cocoartf2636
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red15\green112\blue1;\red255\green255\blue255;\red0\green0\blue0;
\red0\green0\blue255;\red32\green108\blue135;\red0\green0\blue109;\red101\green76\blue29;\red19\green118\blue70;
\red157\green0\blue210;}
{\*\expandedcolortbl;;\cssrgb\c0\c50196\c0;\cssrgb\c100000\c100000\c100000;\cssrgb\c0\c0\c0;
\cssrgb\c0\c0\c100000;\cssrgb\c14902\c49804\c60000;\cssrgb\c0\c6275\c50196;\cssrgb\c47451\c36863\c14902;\cssrgb\c3529\c52549\c34510;
\cssrgb\c68627\c0\c85882;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 //time complexity - O(1)\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2 //space complexity - O(N), N is Math.pow(10, 6)+1\cf0 \cb1 \strokec4 \
\cf2 \cb3 \strokec2 //able to execute in leetcode\cf0 \cb1 \strokec4 \
\pard\pardeftab720\partightenfactor0
\cf5 \cb3 \strokec5 class\cf0 \strokec4  \cf6 \strokec6 MyHashSet\cf0 \strokec4  \{\cb1 \
\pard\pardeftab720\partightenfactor0
\cf0 \cb3     \cf6 \strokec6 int\cf0 \strokec4  \cf7 \strokec7 size\cf0 \strokec4  = (\cf6 \strokec6 int\cf0 \strokec4 )\cf7 \strokec7 Math\cf0 \strokec4 .\cf8 \strokec8 pow\cf0 \strokec4 (\cf9 \strokec9 10\cf0 \strokec4 , \cf9 \strokec9 6\cf0 \strokec4 )+\cf9 \strokec9 1\cf0 \strokec4 ;\cb1 \
\cb3     \cf6 \strokec6 boolean\cf0 \strokec4 [] \cf7 \strokec7 hs\cf0 \strokec4  = \cf10 \strokec10 new\cf0 \strokec4  \cf6 \strokec6 boolean\cf0 \strokec4 [size];\cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf8 \strokec8 MyHashSet\cf0 \strokec4 () \{\cb1 \
\cb3         \cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 void\cf0 \strokec4  \cf8 \strokec8 add\cf0 \strokec4 (\cf6 \strokec6 int\cf0 \strokec4  \cf7 \strokec7 key\cf0 \strokec4 ) \{\cb1 \
\cb3         hs[key] = \cf5 \strokec5 true\cf0 \strokec4 ;\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 void\cf0 \strokec4  \cf8 \strokec8 remove\cf0 \strokec4 (\cf6 \strokec6 int\cf0 \strokec4  \cf7 \strokec7 key\cf0 \strokec4 ) \{\cb1 \
\cb3         hs[key]=\cf5 \strokec5 false\cf0 \strokec4 ;\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf5 \strokec5 public\cf0 \strokec4  \cf6 \strokec6 boolean\cf0 \strokec4  \cf8 \strokec8 contains\cf0 \strokec4 (\cf6 \strokec6 int\cf0 \strokec4  \cf7 \strokec7 key\cf0 \strokec4 ) \{\cb1 \
\cb3         \cf10 \strokec10 return\cf0 \strokec4  hs[key];\cb1 \
\cb3     \}\cb1 \
\cb3 \}\cb1 \
}