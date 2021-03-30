rootProject.name = "tasklist"

include(
    "tasklist",
    ":web:user",
    "repository",
    "model",
    "infrastructure"
)
