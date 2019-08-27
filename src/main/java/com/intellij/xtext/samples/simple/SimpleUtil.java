package com.intellij.xtext.samples.simple;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xtext.samples.simple.psi.SimpleFile;
import com.intellij.xtext.samples.simple.psi.*;

import java.util.*;

public class SimpleUtil {

    public static <T extends SimpleNamedElement> List<T> findElements(Project project, Class<T> tClass, String Id){
        List<T> result = null;
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                T[] elements = PsiTreeUtil.getChildrenOfType(simpleFile, tClass);
                if (elements != null) {
                    for (T property : elements) {
                        if (Id.equals(property.getName())) {
                            if (result == null) {
                                result = new ArrayList<T>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<T>emptyList();
    }
    public static <T extends PsiElement> List<T> findElements(Project project, Class<T> tClass){
        List<T> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                T[] elements = PsiTreeUtil.getChildrenOfType(simpleFile, tClass);
                if (elements != null) {
                    Collections.addAll(result, elements);
                }
            }
        }
        return result ;
    }


    public static List<SimpleEntity> findEntities(Project project) {
        List<SimpleEntity> result = new ArrayList<SimpleEntity>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                SimpleEntity[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleEntity.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}