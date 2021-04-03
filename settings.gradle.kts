rootProject.name = "tasklist"

include(
    "tasklist",
    ":user:profile",
    ":user-core",
    "repository",
    "model",
    "infrastructure"
)
