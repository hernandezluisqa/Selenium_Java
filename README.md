# Selenium_Java

# 📌 Git Workflow & Contribution Guidelines

Although this project is currently maintained by a single contributor, it follows a professional Git workflow to ensure scalability, maintainability, and industry best practices.

---

## 🌿 Branching Strategy

Every new task must be developed in a separate branch.

### 📍 Branch Naming Convention

`type/short-description`

### 🔎 Branch Types

| Type     | Description                                      |
|----------|--------------------------------------------------|
| feature  | New framework functionality                      |
| test     | New automated test case                          |
| fix      | Bug fix                                          |
| refactor | Code improvement without changing behavior       |
| chore    | Maintenance tasks (dependencies, cleanup, etc.)  |
| docs     | Documentation updates                            |
| config   | Environment or configuration changes             |

### ✅ Branch Examples

    feature/add-balance-validation
    test/add-login-test
    fix/fix-explicit-wait-issue
    refactor/improve-basepage-structure
    chore/update-selenium-version
    config/add-qa-environment

### 🚀 Create a New Branch

    git checkout -b test/add-hide-balance-validation

---

## 📝 Commit Message Convention

This project follows a simplified Conventional Commits format.

### 📍 Commit Format

`type(scope): short description`

### 📌 Rules

- Use present tense
- Use imperative mood
- Keep messages concise and meaningful
- One logical change per commit

---

### 🔎 Commit Types

| Type     | Description              |
|----------|--------------------------|
| feat     | New feature              |
| test     | Test creation or update  |
| fix      | Bug fix                  |
| refactor | Code restructuring       |
| chore    | Maintenance tasks        |
| docs     | Documentation updates    |

---

### 📂 Common Scopes

- login
- balance
- transfer
- base
- driver
- config
- utils
- waits

---

### ✅ Commit Examples

    test(balance): validate blur(8px) when balance is hidden
    fix(login): handle explicit wait for dashboard
    refactor(base): extract reusable wait methods
    chore(driver): update selenium to latest version
    docs(readme): add execution instructions

---

## 🔄 Recommended Workflow

1. Create a new branch
2. Implement changes
3. Stage files
4. Commit with proper message
5. Push branch to remote repository

   git add .
   git commit -m "test(balance): validate blur when balance is hidden"
   git push origin test/add-hide-balance-validation

---

## 🌳 Branch Structure

    main      → Stable production-ready code
    develop   → Integration branch
    feature/* → New features
    test/*    → Test cases
    fix/*     → Bug fixes

---

## 🎯 Best Practices

- Keep branches small and focused
- Write clear and descriptive commit messages
- Avoid generic commits like:

        update
        fix stuff
        changes

- Ensure code compiles and tests pass before merging

---