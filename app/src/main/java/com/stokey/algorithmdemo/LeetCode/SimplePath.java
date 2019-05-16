package com.stokey.algorithmdemo.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class SimplePath {
    public static void main(String[] args) {
        System.out.println("/../ ---->" + simplifyPath("/../"));
        System.out.println("/home//foo/ ---->" + simplifyPath("/home//foo/"));
        System.out.println("/a/./b/../../c/ ---->" + simplifyPath("/a/./b/../../c/"));
        System.out.println("/a/../../b/../c//.// ---->" + simplifyPath("/a/../../b/../c//.//"));
        System.out.println("/a//b////c/d//././/.. ---->" + simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        if (path == null) {
            return "/";
        }
        String[] pathArray = path.split("/");
        LinkedList<String> pathList = new LinkedList<String>();
        for (int i = 0; i < pathArray.length; i++) {
            if (!pathArray[i].equals("") && !pathArray[i].equals(".")) {
                if (pathArray[i].equals("..")) {
                    if (!pathList.isEmpty()) {
                        pathList.removeFirst();
                    }
                } else {
                    pathList.push(pathArray[i]);
                }
            }
        }
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("/");
        while (!pathList.isEmpty()) {
            pathBuilder.append(pathList.removeLast());
            if (!pathList.isEmpty()) {
                pathBuilder.append("/");
            }
        }
        return pathBuilder.toString();
    }
}
