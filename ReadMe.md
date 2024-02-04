### Trivial Pursuit Quiz Master

**Small project I threw together in the lead-up to Christmas that serves two purposes:**
1. To have our own quiz master for the family Trivial Pursuit games, because we've exhausted all the questions that came with the game (from 2019).
2. To keep my Jetpack Compose (and other recent androidx libs) skills sharpened - my current role involves using all legacy tech (monolith architecture, xml View system, Rx, etc) and I miss working with modern technologies such as coroutines and Compose.

It's just a simple project that uses the ChatGPT Api to act as a quiz master and generate Trivial Pursuit questions. The questions are returned in a parse-able json format (which ChatGPT abides by _most_ of the time) and contains some extra trivia around the answer.

Requires a (pretty much) free OpenAI api key stored in env variable `OPENAI_API_KEY`.

One issue that has surfaced is content repetition, ChatGPT doesn't offer an API that remembers the conversation, so it tends to ask repetitive questions - as far as I'm aware, the only solution to this is to send the entire conversation history with each request, which is a bit of a pain and results in very bulky request payloads. Perhaps a better and more scalable solution could be done locally with some filtering and retries, which I'll eventually add once local storage is added (though this would result in more frequent requests - maybe there's a trade-off to be discovered here).

#### Tech features:
- Jetpack Compose.
- FragmentFactory in conjunction with vanilla Dagger for DI (Still don't like Hilt, too much code gymnastics required for multi-module projects).
- Fragments for screen hosting, but Compose for Views - I know and trust Fragments for their lifecycle management, and Compose works fine with them, and I don't trust Compose navigation just yet.
- Coroutines - simple setup for Android.
- gradle catalog for dependency management, though buildSrc dependencies is there for centralising some configs that catalog doesn't support.
- Shared common gradle build scrips with `apply from` - not as complex as composite builds IMO, and still allows for a single source of truth for dependencies, configurations, and versions.
- ktlint for code style.

#### TODO:
- Local Storage for conversation history.
- Tests - so I can get used to Compose testing tools.
- Anvil, which is the best choice for DI in multi-module projects.
- Molecule - I'm happy enough with my state management but branching off and trying this out seems like a good idea.
- MultiModule - which shouldn't take much effect, everything in my stack from ViewModel downwards is generally Android-agnostic anyway, I would need to replace OkHttp with Ktor though.