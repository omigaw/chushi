// https://eslint.org/docs/user-guide/configuring

module.exports = {
    root: true,
    parserOptions: {
        parser: 'babel-eslint'
    },
    env: {
        browser: true,
    },
    extends: [
        // https://github.com/vuejs/eslint-plugin-vue#priority-a-essential-error-prevention
        // consider switching to `plugin:vue/strongly-recommended` or `plugin:vue/recommended` for stricter rules.
        'plugin:vue/essential',
        // https://github.com/standard/standard/blob/master/docs/RULES-en.md
        'standard'
    ],
    // required to lint *.vue files
    plugins: [
        'vue'
    ],
    // add your custom rules here
    rules: {
        // allow async-await 生成器星号旁边空格
        'generator-star-spacing': 'off',
        // allow debugger during development 是否允许debugger语句
        'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
        // segment mark 要加分号
        'semi': [2, 'always'],
        // 空格4个
        'indent': ['error', 4, {'SwitchCase': 1}],
        // 对象，键值对，最后一个逗号，1代表warn，模式是，多行的键值对必须加逗号，单行的必需不加。
        // "comma-dangle": 0,
        // 不予许多个空行，最多4个
        "no-multiple-empty-lines": [2, { "max": 4 }],
        // 注释不需要空格
        "spaced-comment": 0
    }
}
