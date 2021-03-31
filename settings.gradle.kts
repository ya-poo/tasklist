rootProject.name = "tasklist"

include(
    "tasklist",
    ":user:profile",
    "repository",
    "model",
    "infrastructure"
)
