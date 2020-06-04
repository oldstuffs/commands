/*
 * MIT License
 *
 * Copyright (c) 2020 Hasan Demirtaş
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.portlek.commands;

import io.github.portlek.commands.cmd.BasicCmd;
import io.github.portlek.commands.context.RegisteredCmd;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface Cmd extends CmdPart<BasicCmd> {

    String CATCHUNKNOWN = "__catchunknown";

    String DEFAULT = "__default";

    @NotNull
    Cmd aliases(@NotNull String... aliases);

    @NotNull
    Collection<String> aliases();

    void register(@NotNull CmdRegistry registry);

    @NotNull
    Map<String, RootCmd> roots();

    @NotNull
    Map<String, RegisteredCmd> registeredCommands();

    @NotNull
    List<String> tabComplete(@NotNull CmdSender sender, @NotNull String commandLabel, @NotNull String[] args);

    @NotNull
    List<String> tabComplete(@NotNull CmdSender sender, @NotNull String commandLabel, @NotNull String[] args,
                             boolean isAsync) throws IllegalArgumentException;

    @NotNull
    List<String> tabComplete(@NotNull CmdSender sender, @NotNull RootCmd rootCommand, @NotNull String[] args,
                             boolean isAsync) throws IllegalArgumentException;

    @NotNull
    List<String> getCommandsForCompletion(@NotNull CmdSender sender, @NotNull String[] args);

}
