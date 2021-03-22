rootProject.name = "tasklist"

include(
    "tasklist",
    ":web:user",
    "data",
    "data-core",
    "infrastructure"
)
