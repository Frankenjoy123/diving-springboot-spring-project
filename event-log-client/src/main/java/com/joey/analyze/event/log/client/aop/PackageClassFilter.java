package com.joey.analyze.event.log.client.aop;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.aop.ClassFilter;

import java.util.*;

/**
 * Created by xiaowu.zhou on 2019/6/20.
 */
public class PackageClassFilter implements ClassFilter {

    private Set<String> packages;
    public static final String BASE_PACKAGE_DELIMITERS = ",; \t\n";


    public void setPackages(String basePackages) {
        Validate.notEmpty(basePackages, "basePackages is emtpy");

        String[] packageArray = toStringArray(basePackages, BASE_PACKAGE_DELIMITERS);
        Validate.notEmpty(packageArray, "empty, basePackages: " + basePackages +
                ", supported delimiters: " + BASE_PACKAGE_DELIMITERS);
        setPackages(Arrays.asList(packageArray));
    }


    public void setPackages(List<String> basePackages) {
        Validate.notEmpty(basePackages, "is emtpy");
        this.packages = new HashSet<>();
        for (String s : basePackages) {
            this.packages.add(s);
        }
    }

    public void setPackages(String[] packages) {
        Validate.notEmpty(packages, "emtpy");
        this.packages = new HashSet<>();
        for (String packageName : packages) {
            this.packages.add(packageName);
        }
    }

    @Override
    public boolean matches(Class<?> clazz) {

        String packageName = ClassUtils.getPackageName(clazz);
        for (String s : this.packages){
            if (packageName.startsWith(s)){
                return true;
            }
        }

        return false;
    }

    public static String[] toStringArray(String str, String delimiters) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            String token = StringUtils.trim(st.nextToken());
            tokens.add(token);
        }

        if (CollectionUtils.isEmpty(tokens)) {
            return null;
        }
        return tokens.toArray(new String[tokens.size()]);
    }
}
