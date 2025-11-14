import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.07"

project {

    vcsRoot(HttpsGithubComMarimargaryan86brbrGitRefsHeadsMain)
    vcsRoot(HttpsGithubComMarimargaryan86brbrGit)
    vcsRoot(HttpsGithubComMarimargaryan86testTw94936gitRefsHeadsMain)
    vcsRoot(HttpsGithubComMarimargaryan86testTw94936git)

    buildType(Build1)
    buildType(Build)
    buildType(Build2)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object Build1 : BuildType({
    name = "Build (1)"

    vcs {
        root(HttpsGithubComMarimargaryan86testTw94936gitRefsHeadsMain)
    }

    steps {
        script {
            name = "sleep"
            id = "sleep"
            scriptContent = "sleep 10"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object Build2 : BuildType({
    name = "Build (2)"

    vcs {
        root(HttpsGithubComMarimargaryan86brbrGitRefsHeadsMain)
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object HttpsGithubComMarimargaryan86brbrGit : GitVcsRoot({
    name = "https://github.com/marimargaryan86/brbr.git"
    url = "https://github.com/marimargaryan86/brbr.git"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "marimargaryan86"
    }
})

object HttpsGithubComMarimargaryan86brbrGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/marimargaryan86/brbr.git#refs/heads/main"
    url = "https://github.com/marimargaryan86/brbr.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "marimargaryan86"
        password = "credentialsJSON:4ec396fe-4be5-4397-9004-3faf0ae7c9dc"
    }
})

object HttpsGithubComMarimargaryan86testTw94936git : GitVcsRoot({
    name = "https://github.com/marimargaryan86/test_TW-94936.git"
    url = "https://github.com/marimargaryan86/test_TW-94936.git"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "marimargaryan"
    }
})

object HttpsGithubComMarimargaryan86testTw94936gitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/marimargaryan86/test_TW-94936.git#refs/heads/main"
    url = "https://github.com/marimargaryan86/test_TW-94936.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "marimargaryan86"
        password = "credentialsJSON:caff8745-cc20-4798-9a5b-89f1d1a82bd3"
    }
})
